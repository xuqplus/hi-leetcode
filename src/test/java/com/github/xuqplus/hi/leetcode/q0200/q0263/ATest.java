package com.github.xuqplus.hi.leetcode.q0200.q0263;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 丑数
 * easy
 * https://leetcode-cn.com/problems/ugly-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isUgly(1));
    }
}

class Solution {

    static List<Integer> excluded = new LinkedList<>();

    public boolean isUgly(int n) {
        if (1 == n) {
            return true;
        }
        for (Integer i : excluded) {
            if (0 == n % i) {
                return false;
            }
        }
        int t = n;
        while (0 == n % 2) {
            n /= 2;
        }
        while (0 == n % 3) {
            n /= 3;
        }
        while (0 == n % 5) {
            n /= 5;
        }
        if (1 != n && n > 5)
            excluded.add(t);
        return 1 == n;
    }
}
