package com.github.xuqplus.hi.leetcode.q0200.q0242;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 有效的字母异位词
 * easy
 * https://leetcode-cn.com/problems/valid-anagram/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isAnagram("bba", "abb"));
    }
}

class Solution {

    public boolean isAnagram(String s, String t) {
        char[] cs0 = s.toCharArray();
        char[] cs1 = t.toCharArray();
        int[] c0 = new int[128];
        int[] c1 = new int[128];
        for (char c : cs0) {
            c0[c] += 1;
        }
        for (char c : cs1) {
            c1[c] += 1;
        }
        for (int i = 0; i < 128; i++) {
            if (c0[i] != c1[i]) {
                return false;
            }
        }
        return true;
    }
}
