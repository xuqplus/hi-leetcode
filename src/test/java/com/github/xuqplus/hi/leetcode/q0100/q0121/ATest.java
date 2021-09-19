package com.github.xuqplus.hi.leetcode.q0100.q0121;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 买卖股票的最佳时机
 * easy
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.maxProfit(new int[]{1}));
    }
}

class Solution {

    // timed out
    static int solution1(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return result;
    }

    static int solution2(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int valley = prices[0], peak = prices[0];
        int result = 0;
        for (int price : prices) {
            if (price < valley) {
                valley = price;
                peak = price;
            } else if (price > peak) {
                peak = price;
                result = Math.max(result, peak - valley);
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        return solution2(prices);
    }
}
