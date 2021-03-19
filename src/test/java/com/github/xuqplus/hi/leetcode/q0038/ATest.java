package com.github.xuqplus.hi.leetcode.q0038;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 外观数列
 * easy
 * https://leetcode-cn.com/problems/count-and-say/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.countAndSay(1));
        log.info("{}", solution.countAndSay(2));
        log.info("{}", solution.countAndSay(3));
        log.info("{}", solution.countAndSay(4));
        log.info("{}", solution.countAndSay(5));
        log.info("{}", solution.countAndSay(6));
        log.info("{}", solution.countAndSay(30));
    }
}

class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        for (int i = 1; i < n; i++) {
            curr = next(curr);
        }
        return curr;
    }

    static String next(String n) {
        final int length = n.length();
        int curr = 1, currCount = 1;
        StringBuilder sb = new StringBuilder();
        for (; curr < length; curr++) {
            if (n.charAt(curr) == n.charAt(curr - 1)) {
                currCount++;
            } else {
                sb.append(String.format("%s%s", currCount, n.charAt(curr - 1)));
                currCount = 1;
            }
        }
        sb.append(String.format("%s%s", currCount, n.charAt(curr - 1)));
        return sb.toString();
    }
}
