package com.github.xuqplus.hi.leetcode.q0100.q0101;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 对称二叉树
 * easy
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isSymmetric(new TreeNode()));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return false;
        }
        return solution1(root.left, root.right);
    }

    static boolean solution1(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return left.val == right.val && solution1(left.left, right.right) && solution1(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
