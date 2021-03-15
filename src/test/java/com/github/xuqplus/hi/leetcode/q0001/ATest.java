package com.github.xuqplus.hi.leetcode.q0001;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        log.info("{}", solution.twoSum(nums, target));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap(); // number - index
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int a = target - b;
            int index;
            if (numMap.containsKey(a) && (index = numMap.get(a)) != i) {
                result[0] = i;
                result[1] = index;
                return result;
            }
            numMap.put(nums[i], i); // 可能不需要遍历整个数组
        }
        return null;
    }
}
