package com.github.xuqplus.hi.leetcode.q0028;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.strStr("hello", "ll"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (null == haystack) {
            return -1;
        }
        if (null == needle || "".equals(needle)) {
            return 0;
        }
        final char first = needle.charAt(0);
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (first == haystack.charAt(i)) {
                if (isHere(haystack, i, needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isHere(String haystack, int i, String needle) {
        for (int j = 1; j < needle.length(); j++) {
            if (haystack.charAt(i + j) != needle.charAt(j))
                return false;
        }
        return true;
    }
}
