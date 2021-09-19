package com.github.xuqplus.hi.leetcode.q0100.q0136;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 只出现一次的数字
 * easy
 * https://leetcode-cn.com/problems/single-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.singleNumber(new int[]{1, 1, 2}));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r ^= nums[i];
        }
        return r;
    }
}
