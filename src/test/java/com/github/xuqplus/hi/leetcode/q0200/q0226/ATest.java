package com.github.xuqplus.hi.leetcode.q0200.q0226;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 翻转二叉树
 * easy
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.invertTree(null));
    }
}

class Solution {

    static void solution(TreeNode node) {
        if (null == node) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        solution(left);
        solution(right);
    }

    public TreeNode invertTree(TreeNode root) {
        solution(root);
        return root;
    }
}
