package com.github.xuqplus.hi.leetcode.q0088;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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
        int[] ints = {1, 2, 3, 0, 0, 0};
        solution.merge(ints, 3, new int[]{2, 3, 6}, 3);
        log.info("{}", ints);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums2 || 0 == nums2.length) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
            sort(nums1, m);
        }
    }

    private void sort(int[] nums, int m) {
        while (m-- > 1) {
            if (nums[m] < nums[m - 1]) {
                int t = nums[m];
                nums[m] = nums[m - 1];
                nums[m - 1] = t;
            } else {
                break;
            }
        }
    }
}
