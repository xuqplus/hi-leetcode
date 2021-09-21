package com.github.xuqplus.hi.leetcode.q0100.q0168;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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
        for (int i = 0; i < 64; i++) {
            log.info("{} - {} - {}", i, Integer.toString(i, 'Z' - 'A' + 1), solution.convertToTitle(i));
        }
    }
}

class Solution {
    public String convertToTitle(int columnNumber) {
        // 'a' 97
        // 'A' 65
        // '0' 48
        String s = Integer.toString(columnNumber, 'Z' - 'A' + 1);
        // the first letter would not be '0'
        char[] r = new char[s.length()];
        for (int i = 1; i < r.length; i++) {
            char c = s.charAt(i);
            char prev = s.charAt(i - 1);
            if ('0' == c) {
                prev -= 1;
            }
            if ('0' <= prev && prev <= '9') {
                prev += 'A' - '0' - 1;
            } else {
                prev += 'A' - 'a' + 10 - 1;
            }
            if ('@' != prev)
                r[i - 1] = prev;
        }
        r[r.length - 1] = trans(s.charAt(r.length - 1));
        return new String(r);
    }

    static char trans(char c) {
        if ('0' == c) {
            return 'Z';
        }
        if ('0' < c && c <= '9') {
            return (char) (c + 'A' - '0' - 1);
        }
        return (char) (c + 'A' - 'a' + 10 - 1);
    }
}
