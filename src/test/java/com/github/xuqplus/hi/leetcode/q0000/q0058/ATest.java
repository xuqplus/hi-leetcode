package com.github.xuqplus.hi.leetcode.q0000.q0058;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 最后一个单词的长度
 * easy
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.lengthOfLastWord("abc"));
        log.info("{}", solution.lengthOfLastWord("abc  "));
        log.info("{}", solution.lengthOfLastWord("ab c  "));
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if (null == s) {
            return 0;
        }
        int max = 0;
        boolean started = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!started) {
                if (' ' != s.charAt(i)) {
                    max++;
                    started = true;
                }
                continue;
            }
            if (' ' == s.charAt(i)) {
                break;
            }
            max++;
        }
        return max;
    }
}
