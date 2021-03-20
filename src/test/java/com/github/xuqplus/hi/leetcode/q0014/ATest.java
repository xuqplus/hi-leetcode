package com.github.xuqplus.hi.leetcode.q0014;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 最长公共前缀
 * easy
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        log.info("{}", solution.longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length || null == strs[0]) {
            return "";
        }
        int minStrIndex = 0;
        String minStr = strs[0];
        for (int i = 0; i < strs.length; i++) {
            final String curr = strs[i];
            if (null == curr || 0 == curr.length()) {
                return "";
            }
            if (curr.length() < minStr.length()) {
                minStr = curr;
                minStrIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < minStr.length(); c++) {
            final char curr = minStr.charAt(c);
            for (int i = 0; i < strs.length; i++) {
                if (i == minStrIndex) {
                    continue;
                }
                if (curr != strs[i].charAt(c)) {
                    return sb.toString();
                }
            }
            sb.append(curr);
        }
        return sb.toString();
    }
}
