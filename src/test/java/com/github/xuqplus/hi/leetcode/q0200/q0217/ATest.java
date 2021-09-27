package com.github.xuqplus.hi.leetcode.q0200.q0217;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * easy
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}

class Solution {

    public boolean containsDuplicate(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
