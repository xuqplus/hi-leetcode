package com.github.xuqplus.hi.leetcode.q0200.q0258;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 各位相加
 * easy
 * https://leetcode-cn.com/problems/add-digits/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.addDigits(11));
    }
}

class Solution {

    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                int c = num % 10;
                sum += c;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
