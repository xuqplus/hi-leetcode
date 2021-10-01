package com.github.xuqplus.hi.leetcode.q0200.q0257;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 * easy
 * https://leetcode-cn.com/problems/binary-tree-paths/
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
        log.info("{}", solution.binaryTreePaths(root));
    }
}

class Solution {

    static void solution(TreeNode node, LinkedList<String> paths, List<String> r) {
        if (null == node) {
            return;
        }
        paths.add(String.valueOf(node.val));
        if (null == node.left && null == node.right) {
            r.add(String.join("->", paths));
        }
        solution(node.left, paths, r);
        solution(node.right, paths, r);
        paths.removeLast();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> r = new ArrayList<>();
        solution(root, new LinkedList<>(), r);
        return r;
    }
}
