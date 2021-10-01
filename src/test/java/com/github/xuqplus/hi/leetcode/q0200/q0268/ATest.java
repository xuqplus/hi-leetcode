package com.github.xuqplus.hi.leetcode.q0200.q0268;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 丢失的数字
 * easy
 * https://leetcode-cn.com/problems/missing-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.missingNumber(null));
    }
}

class Solution {

    public int missingNumber(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        for (int num : nums) {
            flag[num] = true;
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                return i;
            }
        }
        return -1;
    }
}
