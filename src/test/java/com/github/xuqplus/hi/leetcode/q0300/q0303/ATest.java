package com.github.xuqplus.hi.leetcode.q0300.q0303;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 区域和检索 -数组不可变
 * easy
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        NumArray solution = new NumArray(null);
        log.info("{}", solution);
    }
}

class NumArray {

    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int r = 0;
        for (int i = left; i <= right; i++) {
            r += nums[i];
        }
        return r;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
