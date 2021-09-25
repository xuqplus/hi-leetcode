package com.github.xuqplus.hi.leetcode.q0100.q0190;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 颠倒二进制位
 * easy
 * https://leetcode-cn.com/problems/reverse-bits/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.reverseBits(0xffff0000));
        log.info("{}", solution.reverseBits(0x0000ffff));
    }
}

class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // return Integer.reverse(n);
        int r = 0;
        for (int i = 0; i < 16; i++) {
            r |= ((0b00000000000000000000000000000001 << i) & n) << (32 - i - i - 1);
            r |= ((0b10000000000000000000000000000000 >>> i) & n) >>> (32 - i - i - 1);
        }
        return r;
    }
}
