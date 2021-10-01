package com.github.xuqplus.hi.leetcode.q0200.q0237;

import com.github.xuqplus.hi.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 删除链表中的节点
 * easy
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        head.next = n0;
        n0.next = n1;
        solution.deleteNode(n0);
    }
}

class Solution {

    public void deleteNode(ListNode node) {
        while (null != node.next.next) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
