package com.github.xuqplus.hi.leetcode.q0020;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 有效的括号
 * easy
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isValid("()[]{}"));
        log.info("{}", solution.isValid("(}"));
        log.info("{}", solution.isValid("("));
        log.info("{}", solution.isValid("({])"));
    }
}

class Solution {
    public boolean isValid(String s) {
        int c0 = 0, c1 = 0, c2 = 0; // (, [, {
        LinkedList<Character> next = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                c0--;
                next.add(')');
            } else if (')' == c && (++c0 > 0 || next.size() <= 0 || next.removeLast() != ')')) {
                return false;
            } else if ('[' == c) {
                c1--;
                next.add(']');
            } else if (']' == c && (++c1 > 0 || next.size() <= 0 || next.removeLast() != ']')) {
                return false;
            } else if ('{' == c) {
                c2--;
                next.add('}');
            } else if ('}' == c && (++c2 > 0 || next.size() <= 0 || next.removeLast() != '}')) {
                return false;
            }
        }
        if (0 != c0 || 0 != c1 || 0 != c2) {
            return false;
        }
        return true;
    }
}
