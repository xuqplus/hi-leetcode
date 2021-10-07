package com.github.xuqplus.hi.leetcode.q0200.q0290;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 单词规律
 * easy
 * https://leetcode-cn.com/problems/word-pattern/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.wordPattern("abba", "dog cat cat fish"));
    }
}

class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (!map.containsKey(split[i]) && !map2.containsKey(pattern.charAt(i))) {
                map.put(split[i], pattern.charAt(i));
                map2.put(pattern.charAt(i), split[i]);
                continue;
            }
            if (!Objects.equals(map.get(split[i]), pattern.charAt(i))) {
                return false;
            }
            if (!Objects.equals(map2.get(pattern.charAt(i)), split[i])) {
                return false;
            }
        }
        return true;
    }
}
