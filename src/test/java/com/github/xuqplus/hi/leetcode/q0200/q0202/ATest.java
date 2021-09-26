package com.github.xuqplus.hi.leetcode.q0200.q0202;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * easy
 * https://leetcode-cn.com/problems/happy-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isHappy(1));
    }
}

class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (true) {
            if (1 == n)
                return true;
            if (set.contains(n))
                return false;
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int t = n % 10;
                sum += t * t;
                n /= 10;
            }
            n = sum;
        }
    }
}
