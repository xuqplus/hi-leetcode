package com.github.xuqplus.hi.leetcode.gen;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

/**
 * To generate answer test cases templates
 */
@Slf4j
public class TemplateGenerationTest {

    static String file = "src/test/java/com/github/xuqplus/hi/leetcode/gen/all.xml";
    static String qTemplate = "src/test/java/com/github/xuqplus/hi/leetcode/gen/templates/q.txt";
    static String qOut = "src/test/java/com/github/xuqplus/hi/leetcode/%s/ATest.java";

    @Test
    void generate() {
        log.info("haha");
    }

    @Test
    void createQXxx() {
        createQXxx(99);
    }

    @Test
    void createQ1794() {
        final JSONArray[] questions = getQuestions();
        for (JSONArray q : questions) {
            final Question question = Question.newInstance(q);
            if (null != question && null != question.getNumber()) {
                createQXxx(question);
            }
        }
    }

    /**
     * generate simple template, questions with number serial number
     */
    void createQXxx(int number) {
        final Question question = getQuestion(number);
        createQXxx(question);
    }

    void createQXxx(Question question) {
        if (null == question || null == question.getNumber() || null == question.getTitle()
                || null == question.getLevel() || null == question.getUrl()) {
            log.error("failed to generate template source file, question => {}", question);
            return;
        }
        log.info("{}", question);
        try {
            final String template = Files.readString(new File(qTemplate).toPath());
            final String directory = String.format("q%04d", question.getNumber());
            final String packaga = String.format("q%02d00.q%04d", question.getNumber() / 100, question.getNumber());
            File out = new File(String.format(qOut, directory));
            File moved = new File(String.format(qOut, String.format("q%02d00/q%04d", question.getNumber() / 100, question.getNumber())));
            if (out.exists()) {
                String content = Files.readString(out.toPath());
                String packageLine = String.format("package com.github.xuqplus.hi.leetcode.%s;", directory);
                String packageLineMoved = String.format("package com.github.xuqplus.hi.leetcode.%s;", packaga);
                content = content.replace(packageLine, packageLineMoved);
                moved.getParentFile().mkdirs();
                Files.writeString(moved.toPath(), content);
                log.info("file moved => {}", moved.getPath());
                out.delete();
                if (ObjectUtils.isEmpty(out.getParentFile().list())) {
                    out.getParentFile().delete();
                }
                return;
            }
            if (moved.exists()) {
                log.info("file exists => {}", out.getPath());
                return;
            }
            out = moved;
            final String content = template.replace("#package#", packaga)
                    .replace("#title#", question.getTitle())
                    .replace("#level#", question.getLevel())
                    .replace("#url#", question.getUrl());
            log.info("going to write \n\"{}\" with content => \n{}\n<=", out.getPath(), content);
            try {
                out.getParentFile().mkdirs();
                Files.writeString(out.toPath(), content);
            } catch (IOException e) {
                log.error("failed to write file => {}", out.getPath(), e);
            }
        } catch (IOException e) {
            log.error("failed to read template file => {}", qTemplate, e);
        }
    }

    private Question getQuestion(int number) {
        final JSONArray[] questions = getQuestions();
        for (JSONArray question : questions) {
            Question q = Question.newInstance(question);
            if (null != q.getNumber() && number == q.getNumber()) {
                return q;
            }
        }
        return null;
    }

    @Data
    private static class Question {
        private Integer number;
        private String title;
        private String level;
        private String url;

        Question() {
        }

        static Question newInstance(JSONArray array) {
            Question q = new Question();
            if (null != array && array.size() >= 5) {
                // number
                if (array.get(0) instanceof String) {
                    try {
                        q.number = Integer.parseInt((String) array.get(0));
                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
                    }
                }
                // title & url
                if (array.get(1) instanceof Map) {
                    final Map map = (Map) array.get(1);
                    if (map.get("span") instanceof Map) {
                        final Map span = (Map) map.get("span");
                        if (span.get("div") instanceof Map) {
                            final Map div = (Map) span.get("div");
                            if (div.get("a") instanceof Map) {
                                final Map a = (Map) div.get("a");
                                if (a.get("href") instanceof String) {
                                    q.url = String.format("https://leetcode-cn.com%s/", ((String) a.get("href")).trim());
                                }
                                if (a.get("") instanceof String) {
                                    q.title = ((String) a.get("")).trim();
                                }
                            }
                        }
                    }
                }
                // level
                if (array.get(4) instanceof Map) {
                    final Map map = (Map) array.get(4);
                    if (map.get("span") instanceof Map) {
                        final Map span = (Map) map.get("span");
                        if (span.get("class") instanceof String) {
                            final String clazz = (String) span.get("class");
                            q.level = clazz.trim().substring("level-".length());
                        }
                    }
                }
            }
            return q;
        }
    }

    JSONArray[] questions = null;

    private synchronized JSONArray[] getQuestions() {
        if (null != questions) {
            return questions;
        }
        final XMLInputFactory factory = XMLInputFactory.newFactory();
        JSONArray[] list = new JSONArray[0];
        try (FileInputStream fis = new FileInputStream(file)) {
            final XMLStreamReader reader = factory.createXMLStreamReader(fis);
            final XmlMapper mapper = new XmlMapper();
            list = mapper.readValue(reader, JSONArray[].class);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (XMLStreamException e) {
//            e.printStackTrace();
        }
        return questions = list;
    }
}
