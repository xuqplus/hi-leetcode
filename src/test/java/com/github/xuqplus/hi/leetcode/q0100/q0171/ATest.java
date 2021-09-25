package com.github.xuqplus.hi.leetcode.q0100.q0171;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Excel表列序号
 * easy
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.titleToNumber("AA"));
        log.info("{}", solution.titleToNumber("AB"));
    }
}

class Solution {

    static final long radix = 26;

    public int titleToNumber(String columnTitle) {
        long r = 0;
        byte[] bytes = columnTitle.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            long c = Double.valueOf(Math.pow(radix, bytes.length - i - 1)).longValue();
            r += c * (bytes[i] - '@');
        }
        return (int) r;
    }
}
