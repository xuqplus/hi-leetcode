package com.github.xuqplus.hi.leetcode.q0200.q0283;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 移动零
 * easy
 * https://leetcode-cn.com/problems/move-zeroes/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0, 1});
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}

class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (int num : nums) {
            if (0 == num) {
                j++;
                continue;
            }
            nums[i++] = nums[j++];
        }
        if (0 == i) {
            return;
        }
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
