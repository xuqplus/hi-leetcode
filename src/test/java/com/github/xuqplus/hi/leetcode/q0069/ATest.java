package com.github.xuqplus.hi.leetcode.q0069;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * x 的平方根
 * easy
 * https://leetcode-cn.com/problems/sqrtx/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.mySqrt(2147395599));
    }
}

class Solution {
    // dichotomy
    public int mySqrt(long x) {
        if (0 >= x) {
            return 0;
        }
        // (0, x];
        long a = x;
        long d = x >> 1;
        long a_2;
        boolean minus;
        while ((minus = (a_2 = a * a) > x) || a_2 + a * 2 + 1 <= x) {
            if (minus) {
                a -= d;
            } else {
                a += d;
            }
            d >>= 1;
            if (0 >= d)
                d = 1;
        }
        return (int) a;
    }
}
