package com.github.xuqplus.hi.leetcode.q0200.q0231;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 2的幂
 * easy
 * https://leetcode-cn.com/problems/power-of-two/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isPowerOfTwo(1));
    }
}

class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return 1 == Integer.bitCount(n);
    }
}
