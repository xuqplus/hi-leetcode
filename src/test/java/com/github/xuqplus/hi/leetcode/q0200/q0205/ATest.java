package com.github.xuqplus.hi.leetcode.q0200.q0205;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 同构字符串
 * easy
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isIsomorphic("foo", "bar"));
    }
}

class Solution {

    public boolean isIsomorphic(String s, String t) {
        char[] cs = new char[128];
        char[] cs2 = new char[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            if ('\0' == cs[c]) {
                cs[c] = c2;
            } else if (cs[c] != c2) {
                return false;
            }
            if ('\0' == cs2[c2]) {
                cs2[c2] = c;
            } else if (cs2[c2] != c) {
                return false;
            }
        }
        return true;
    }
}
