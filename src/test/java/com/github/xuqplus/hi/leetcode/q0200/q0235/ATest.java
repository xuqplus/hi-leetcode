package com.github.xuqplus.hi.leetcode.q0200.q0235;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 二叉搜索树的最近公共祖先
 * easy
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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
        log.info("{}", solution.lowestCommonAncestor(root, l0, l1).val);
    }
}

class Solution {

    static int solution(TreeNode node, TreeNode p, TreeNode q, TreeNode[] r) {
        if (null != r[0]) {
            return 0;
        }
        if (null == node) {
            return 0;
        }
        int count = 0;
        if (p == node || q == node) {
            count = 1;
        }
        int a = solution(node.left, p, q, r);
        int b = solution(node.right, p, q, r);
        count += a + b;
        if (null == r[0] && count > 1) {
            r[0] = node;
        }
        return count;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] r = new TreeNode[1];
        solution(root, p, q, r);
        return r[0];
    }
}
