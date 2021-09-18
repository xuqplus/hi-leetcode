package com.github.xuqplus.hi.leetcode.q0000.q0026;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        log.info("{}", solution.removeDuplicates(nums));
        log.info("{}", nums);
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int size = nums.length;
        for (int i = 0; i < size - 1; ) {
            if (nums[i] == nums[i + 1]) {
                size--;
                System.arraycopy(nums, i + 1, nums, i, size - i);
                continue;
            }
            i++;
        }
        return size;
    }

    // 10 times slower
//    private void move(int[] nums, int i, int[] nums1, int i1, int length) {
//        for (int j = 0; j < length - 1; j++) {
//            nums[i + j] = nums[i + j + 1];
//        }
//    }
}
