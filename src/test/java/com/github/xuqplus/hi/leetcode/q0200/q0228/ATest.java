package com.github.xuqplus.hi.leetcode.q0200.q0228;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 汇总区间
 * easy
 * https://leetcode-cn.com/problems/summary-ranges/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.summaryRanges(new int[]{1, 2, 3, 5}));
    }
}

class Solution {

    public List<String> summaryRanges(int[] nums) {
        if (null == nums || nums.length < 1) {
            return Collections.emptyList();
        }
        List<String> r = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                count++;
                continue;
            }
            if (0 == count) {
                r.add(String.valueOf(nums[i]));
            } else {
                r.add(nums[i - count] + "->" + nums[i]);
            }
            count = 0;
        }
        if (0 == count) {
            r.add(String.valueOf(nums[nums.length - 1]));
        } else {
            r.add(nums[nums.length - 1 - count] + "->" + nums[nums.length - 1]);
        }
        return r;
    }
}
