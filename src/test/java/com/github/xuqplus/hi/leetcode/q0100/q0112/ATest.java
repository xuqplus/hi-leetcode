package com.github.xuqplus.hi.leetcode.q0100.q0112;

import com.github.xuqplus.hi.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 路径总和
 * easy
 * https://leetcode-cn.com/problems/path-sum/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.hasPathSum(null, 1));
    }
}

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        boolean[] result = {false};
        solution(root, root.val, result, targetSum);
        return result[0];
    }

    static void solution(TreeNode node, int sum, boolean[] r, int target) {
        if (r[0]) {
            return;
        }
        if (null == node.left && null == node.right && sum == target) {
            r[0] = true;
            return;
        }
        if (null != node.left) {
            solution(node.left, sum + node.left.val, r, target);
        }
        if (null != node.right) {
            solution(node.right, sum + node.right.val, r, target);
        }
    }
}
