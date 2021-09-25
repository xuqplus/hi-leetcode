package com.github.xuqplus.hi.leetcode.q0100.q0169;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 多数元素
 * easy
 * https://leetcode-cn.com/problems/majority-element/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.majorityElement(new int[]{1}));
    }
}

class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
