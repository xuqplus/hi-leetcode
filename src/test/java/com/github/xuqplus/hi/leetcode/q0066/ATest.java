package com.github.xuqplus.hi.leetcode.q0066;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 加一
 * easy
 * https://leetcode-cn.com/problems/plus-one/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.plusOne(new int[]{1, 2, 3}));
        log.info("{}", solution.plusOne(new int[]{9, 9, 9}));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            boolean up = plusOne(digits, i);
            if (up) {
                if (0 == i) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    return result;
                }
            } else {
                break;
            }
        }
        return digits;
    }

    private boolean plusOne(int[] digits, int i) {
        int n = digits[i];
        if (n < 9) {
            digits[i] = n + 1;
            return false;
        } else {
            digits[i] = 0;
            return true;
        }
    }
}
