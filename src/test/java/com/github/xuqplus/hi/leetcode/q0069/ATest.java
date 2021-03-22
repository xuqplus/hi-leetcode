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
        log.info("{}", solution.mySqrt(36));
    }
}

class Solution2 {
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

class Solution {
    // Newton-Raphson method
    public int mySqrt(final long c) {
        if (0 >= c) {
            return 0;
        }
        long x = c;
        long x_2;
        while ((x_2 = x * x) > c || x_2 + x * 2 + 1 <= c) {
            x = ((c + x_2) / x) >> 1;
        }
        return (int) x;
    }
}
