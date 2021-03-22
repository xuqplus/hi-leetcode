package com.github.xuqplus.hi.leetcode.q0088;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * easy
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int[] ints = {2, 0};
        solution.merge(ints, 1, new int[]{1}, 1);
        log.info("{}", ints);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums2 || 0 == nums2.length) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
