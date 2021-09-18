package com.github.xuqplus.hi.leetcode.q0110;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 平衡二叉树
 * easy
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isBalanced(new TreeNode()));
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return solution(root);
    }

    // optimized - but use less
    static Map<TreeNode, Integer> subTreeHeight = new HashMap<>();

    static boolean solution(TreeNode node) {
        boolean[] result = {true};
        height(node, result);
        return result[0];
    }

    static int height(TreeNode node, boolean[] r) {
        if (!r[0]) {
            return -1;
        }
        if (null == node) {
            return 0;
        }
        Integer cache = subTreeHeight.get(node);
        if (null != cache) {
            return cache;
        }
        int lh = height(node.left, r);
        int rh = height(node.right, r);
        if (Math.abs(lh - rh) > 1) {
            r[0] = false;
        }
        int h = 1 + Math.max(lh, rh);
        subTreeHeight.put(node, h);
        return h;
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
