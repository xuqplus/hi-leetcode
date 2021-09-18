package com.github.xuqplus.hi.leetcode.q0000.q0035;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int[] nums = {3,};
        log.info("{}", solution.searchInsert(nums, 5));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (null == nums) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
