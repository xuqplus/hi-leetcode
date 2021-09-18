package com.github.xuqplus.hi.leetcode.q0000.q0053;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 最大子序和
 * easy
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // collect the max value
            if (nums[i] > max) {
                max = nums[i];
                // todo, record the max sub array if needed
            }
            // collect the max summary
            sum += nums[i];
            if (sum > max) {
                max = sum;
                // todo, record the max sub array if needed
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
