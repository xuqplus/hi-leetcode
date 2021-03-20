package com.github.xuqplus.hi.leetcode.q0009;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 回文数
 * easy
 * https://leetcode-cn.com/problems/palindrome-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isPalindrome(1234321));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int x1 = x % 10, x0 = x;
        while ((x /= 10) > 0) {
            x1 *= 10;
            x1 += x % 10;
        }
        return x0 == x1;
    }
}
