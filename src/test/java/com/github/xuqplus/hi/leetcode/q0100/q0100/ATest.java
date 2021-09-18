package com.github.xuqplus.hi.leetcode.q0100.q0100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 相同的树
 * easy
 * https://leetcode-cn.com/problems/same-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.isSameTree(new TreeNode(), new TreeNode()));
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == q && p == null) {
            return true;
        }
        if (null == p || q == null || q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
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
