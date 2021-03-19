package com.github.xuqplus.hi.leetcode.q0038;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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
        BigInteger curr = BigInteger.ONE;
        String currStr = "1";
        for (int i = 1; i < n; i++) {
            currStr = next(curr);
            curr = new BigInteger(currStr);
        }
        return currStr;
    }

    static String next(BigInteger last) {
        BigInteger n = last;
        BigInteger curr = n.mod(BigInteger.TEN);
        int currCount = 1;
        StringBuilder sb = new StringBuilder();
        while (n.compareTo(BigInteger.ZERO) > 0) {
            n = n.divide(BigInteger.TEN);
            if (n.mod(BigInteger.TEN).equals(curr)) {
                currCount++;
            } else {
                sb.insert(0, String.format("%s%s", currCount, curr));
                curr = n.mod(BigInteger.TEN);
                currCount = 1;
            }
        }
        return sb.toString();
    }
}
