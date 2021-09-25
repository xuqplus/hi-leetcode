package com.github.xuqplus.hi.leetcode.q0100.q0191;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 位1的个数
 * easy
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.hammingWeight(3));
    }
}

class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int r = 0;
        for (int i = 0; i < 16; i++) {
            if (0 != ((0b1000_0000_0000_0000_0000_0000_0000_0000 >>> i) & n)) {
                r++;
            }
            if (0 != ((0b0000_0000_0000_0000_0000_0000_0000_0001 << i) & n)) {
                r++;
            }
        }
        return r;
    }
}
