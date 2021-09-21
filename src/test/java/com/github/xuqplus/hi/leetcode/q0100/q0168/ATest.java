package com.github.xuqplus.hi.leetcode.q0100.q0168;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Excel表列名称
 * easy
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        // FXSHRXW - ETKGTMW
        log.info("{} - {}", 2147483647, solution.convertToTitle(2147483647));
        log.info("{} - {}", 703, solution.convertToTitle(703));
        for (int i = 25; i < 64; i++) {
            log.info("{} - {}", i, solution.convertToTitle(i));
        }
        for (int i = 676; i < 711; i++) {
            log.info("{} - {}", i, solution.convertToTitle(i));
        }
    }
}

class Solution {

    static final int radix = 26;
    static final long min = 1;
    static final long max = Double.valueOf(Math.pow(2, 31)).longValue() - 1;
    static final long[] c0 = new long[6];
    static final long[] c1 = new long[6];

    {
        long i = radix;
        long sum = i;
        List<Long> list0 = new ArrayList<>();
        List<Long> list1 = new ArrayList<>();
        while (sum <= max) {
            list0.add(0, i);
            list1.add(0, sum);
            i *= radix;
            sum += i;
        }
        for (int j = 0; j < 6; j++) {
            c0[j] = list0.get(j);
            c1[j] = list1.get(j);
        }
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber < min || max < columnNumber) {
            return null;
        }
        long target = columnNumber;
        int i = 0;
        int[] arr = new int[c0.length + 1];
        int count = 0;
        while (target > 0 && i < 6) {
            if (target > c1[i]) {
                target -= c0[i];
                count++;
                continue;
            }
            arr[i++] = count;
            count = 0;
        }
        arr[i] = (int) target;
        StringBuilder sb = new StringBuilder();
        for (int c : arr) {
            if (c > 0)
                sb.append(Character.valueOf((char) ('@' + c)));
        }
        return sb.toString();
    }
}
