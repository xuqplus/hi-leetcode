package com.github.xuqplus.hi.leetcode.q0200.q0292;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Nim 游戏
 * easy
 * https://leetcode-cn.com/problems/nim-game/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.canWinNim(1));
    }
}

class Solution {

    public boolean canWinNim(int n) {
        return 0 != (n & 3);
    }
}
