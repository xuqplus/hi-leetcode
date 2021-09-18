package com.github.xuqplus.hi.leetcode.q0100.q0110;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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

    static boolean solution(TreeNode node) {
        Boolean[] result = {true};
        Thread thread = new Thread(() -> {
            height(node, result);
            synchronized (result) {
                result.notify();
            }
        });
        thread.start();
        synchronized (result) {
            try {
                result.wait();
            } catch (InterruptedException e) {
                //
            }
        }
        return result[0];
    }

    static int height(TreeNode node, Boolean[] r) {
        if (!r[0]) {
            return -1;
        }
        if (null == node) {
            return 0;
        }
        int lh = height(node.left, r);
        int rh = height(node.right, r);
        if (Math.abs(lh - rh) > 1) {
            r[0] = false;
            synchronized (r) {
                r.notify();
            }
        }
        return 1 + Math.max(lh, rh);
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
