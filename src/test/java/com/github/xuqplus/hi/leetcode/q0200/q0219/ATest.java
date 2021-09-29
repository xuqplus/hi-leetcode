package com.github.xuqplus.hi.leetcode.q0200.q0219;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素 II
 * easy
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        // log.info("{}", solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        log.info("{}", solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }
}

class Solution {

    static boolean solution(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int top = Math.min(i + k + 1, nums.length);
            for (int j = i + 1; j < top; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean solution2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int k2 = Math.min(nums.length, k);
        for (int i = 0; i < k2; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            set.remove(nums[i - k]);
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return solution2(nums, k);
    }
}
