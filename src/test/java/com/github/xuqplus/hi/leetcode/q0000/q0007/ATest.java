package com.github.xuqplus.hi.leetcode.q0000.q0007;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int target = -2147483648;
        log.info("{}", solution.reverse(target));
    }
}

class Solution {
    public int reverse(int x) {
        if (0 == x || Integer.MIN_VALUE == x) {
            return 0;
        }
        if (0 < x) {
            try {
                return Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return -reverse(-x);
    }
}
