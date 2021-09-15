package com.github.xuqplus.hi.leetcode.q0070;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 爬楼梯 easy https://leetcode-cn.com/problems/climbing-stairs/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.climbStairs(10));
    }
}

class Solution {

    static Map<Integer, Integer> map = new HashMap();

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (2 >= n) {
            return n;
        }
        int r = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, r);
        return r;
    }
}
