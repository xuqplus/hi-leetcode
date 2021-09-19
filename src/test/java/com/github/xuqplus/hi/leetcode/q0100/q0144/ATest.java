package com.github.xuqplus.hi.leetcode.q0100.q0144;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    static void solution(TreeNode node, List<Integer> r) {
        if (null == node) {
            return;
        }
        r.add(node.val);
        solution(node.left, r);
        solution(node.right, r);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solution(root, result);
        return result;
    }
}
