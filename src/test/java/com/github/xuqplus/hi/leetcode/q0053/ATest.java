package com.github.xuqplus.hi.leetcode.q0053;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> markNonNegative = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] >= 0) {
                markNonNegative.add(i);
            }
        }
        if (1 >= markNonNegative.size()) {
            return max;
        }
        for (int i = 0; i < markNonNegative.size() - 1; i++) {
            for (int j = i + 1; j < markNonNegative.size(); j++) {
                int sum = sum(nums, markNonNegative.get(i), markNonNegative.get(j));
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    static int sum(int[] nums, int start, int end) {
        int sum = nums[end];
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
