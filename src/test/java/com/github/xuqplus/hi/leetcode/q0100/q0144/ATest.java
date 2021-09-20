package com.github.xuqplus.hi.leetcode.q0100.q0144;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * medium
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(-100);
        TreeNode l0 = new TreeNode(-200);
        TreeNode l1 = new TreeNode(-50);
        TreeNode r = new TreeNode(100);
        TreeNode r0 = new TreeNode(50);
        TreeNode r1 = new TreeNode(200);
        root.left = l;
        l.left = l0;
        l.right = l1;
        root.right = r;
        r.left = r0;
        r.right = r1;
        log.info("{}", solution.preorderTraversal(root));
    }
}

class Solution {

    // recursion
    static void solution(TreeNode node, List<Integer> r) {
        if (null == node) {
            return;
        }
        r.add(node.val);
        solution(node.left, r);
        solution(node.right, r);
    }

    // loop / circulation
    static void solution2(TreeNode node, List<Integer> r) {
        if (null == node) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(node);
        for (; !stack.isEmpty(); ) {
            TreeNode pop = stack.removeLast();
            r.add(pop.val); // preorder
            if (null != pop.right)
                stack.add(pop.right);
            if (null != pop.left)
                stack.add(pop.left);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solution2(root, result);
        return result;
    }
}
