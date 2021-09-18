package com.github.xuqplus.hi.leetcode.q0104;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 二叉树的最大深度
 * easy
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode();
        root.val = 0;
        root.left = new TreeNode();
        root.left.val = -1;
        root.right = new TreeNode();
        root.right.val = 1;
        log.info("{}", solution.maxDepth(root));
    }
}

class Solution {

    public int maxDepth(TreeNode root) {
        return solution2(root);
    }

    // recursion
    static int solution2(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return 1 + Math.max(solution2(node.left), solution2(node.right));
    }

    // step by step / up & down
    static int solution1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode curr = root;
        boolean down = true;
        int result = 1, h = 1;
        while (true) {
            if (down) {
                if (null != curr.left) {
                    list.add(curr);
                    curr = curr.left;
                    h++;
                } else if (null != curr.right) {
                    list.add(curr);
                    curr = curr.right;
                    h++;
                } else {
                    down = false;
                }
            } else {
                if (h <= 1) {
                    return result;
                }
                if (curr == list.getLast().left && null != list.getLast().right) {
                    curr = list.getLast().right;
                    down = true;
                } else {
                    curr = list.removeLast();
                    h--;
                }
            }
            result = Math.max(h, result);
        }
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