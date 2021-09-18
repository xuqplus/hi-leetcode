package com.github.xuqplus.hi.leetcode.q0100.q0108;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 将有序数组转换为二叉搜索树
 * easy
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        int[] a = {-10, -3, 0, 2, 3};
        TreeNode node = solution.sortedArrayToBST(a);
        log.info("{}", node);
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        return solution(nums, 0, nums.length - 1);
    }

    static TreeNode solution(int[] arr, int left, int right) {
        if (right - left < 0) {
            return null;
        }
        int i = (right + left) / 2;
        TreeNode node = new TreeNode(arr[i]);
        node.left = solution(arr, left, i - 1);
        node.right = solution(arr, i + 1, right);
        return node;
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
