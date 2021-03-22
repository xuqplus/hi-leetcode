package com.github.xuqplus.hi.leetcode.q0067;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 二进制求和
 * easy
 * https://leetcode-cn.com/problems/add-binary/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.addBinary("11", "1"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        final String x = a.length() > b.length() ? a : b;
        final String y = a.length() <= b.length() ? a : b;
        final int max = x.length();
        final int min = y.length();
        final StringBuilder sb = new StringBuilder();
        int i = max - 1;
        boolean up = false;
        for (; i >= max - min; i--) {
            if (up) {
                up = add(sb, x.charAt(i), y.charAt(i + min - max), true);
            } else {
                up = add(sb, x.charAt(i), y.charAt(min + i - max));
            }
        }
        for (; i >= 0; i--) {
            if (up) {
                up = add(sb, x.charAt(i), '0', true);
            } else {
                up = add(sb, x.charAt(i), '0');
            }
        }
        if (up) {
            sb.insert(0, '1');
            return sb.toString();
        }
        return sb.toString();
    }

    private boolean add(StringBuilder sb, char a, char b, boolean up) {
        if ('1' == a) {
            sb.insert(0, b);
        } else if ('1' == b) {
            sb.insert(0, a);
        } else {
            sb.insert(0, '1');
            return false;
        }
        return true;
    }

    static boolean add(StringBuilder sb, char a, char b) {
        if ('0' == a) {
            sb.insert(0, b);
        } else if ('0' == b) {
            sb.insert(0, a);
        } else {
            sb.insert(0, '0');
            return true;
        }
        return false;
    }
}
