package com.github.xuqplus.hi.leetcode.q0300.q0326;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3的幂
 * easy
 * https://leetcode-cn.com/problems/power-of-three/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isPowerOfThree(1));
    }
}

class Solution {

    static Set<Integer> PO3 = new HashSet<>();

    static {
        int n = 1;
        while (n > 0) {
            PO3.add(n);
            n = (int) (3 * n);
        }
    }

    public boolean isPowerOfThree(int n) {
        return PO3.contains(n);
    }
}
