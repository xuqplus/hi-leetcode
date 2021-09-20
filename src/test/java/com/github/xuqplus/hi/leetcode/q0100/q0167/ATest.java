package com.github.xuqplus.hi.leetcode.q0100.q0167;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int k = target - numbers[i];
            Integer index = map.get(k);
            if (null != index) {
                return new int[]{i + 1, index + 1};
            }
        }
        return null;
    }
}
