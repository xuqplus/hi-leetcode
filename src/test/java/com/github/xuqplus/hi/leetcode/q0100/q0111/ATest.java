package com.github.xuqplus.hi.leetcode.q0100.q0111;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 二叉树的最小深度
 * easy
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.minDepth(null));
    }
}

class Solution {

    public int minDepth(TreeNode root) {
        return 0;
    }
}