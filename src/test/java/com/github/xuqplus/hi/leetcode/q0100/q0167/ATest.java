package com.github.xuqplus.hi.leetcode.q0100.q0167;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 两数之和 II - 输入有序数组
 * easy
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.twoSum(new int[]{1, 2, 3}, 4));
    }
}

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (true) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
    }
}
