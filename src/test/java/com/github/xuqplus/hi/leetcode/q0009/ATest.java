package com.github.xuqplus.hi.leetcode.q0009;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文数
 * easy
 * https://leetcode-cn.com/problems/palindrome-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isPalindrome(1234321));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        nums.add(x % 10);
        while ((x /= 10) > 0) {
            nums.add(x % 10);
        }
        for (int i = 0; i <= nums.size() / 2; i++) {
            if (nums.get(i) != nums.get(nums.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
