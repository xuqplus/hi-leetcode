package com.github.xuqplus.hi.leetcode.q0100.q0125;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * 验证回文串
 * easy
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}

class Solution {

    static int a = 'a';
    static int z = 'z';
    static int A = 'A';
    static int Z = 'Z';
    static int zero = '0';
    static int nine = '9';

    static boolean isIncluded(char c) {
        if (a <= c && c <= z) {
            return true;
        }
        if (A <= c && c <= Z) {
            return true;
        }
        if (zero <= c && c <= nine) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        if (Objects.isNull(s)) {
            return false;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++) {
            char ci = s.charAt(i);
            if (isIncluded(ci)) {
                for (; i < j; j--) {
                    char cj = s.charAt(j);
                    if (isIncluded(cj)) {
                        if (ci == cj || Character.toLowerCase(ci) == Character.toLowerCase(cj)) {
                            j--;
                            break;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
