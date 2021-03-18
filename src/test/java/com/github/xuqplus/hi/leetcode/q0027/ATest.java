package com.github.xuqplus.hi.leetcode.q0027;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int[] nums = {0, 1, 1, 0,};
        log.info("{}", solution.removeElement(nums, 0));
        log.info("{}", nums);
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        if (null == nums) {
            return 0;
        }
        int size = nums.length;
        for (int i = 0; i < size; ) {
            if (nums[i] == val) {
                size--;
                System.arraycopy(nums, i + 1, nums, i, size - i);
                continue;
            }
            i++;
        }
        return size;
    }
}
