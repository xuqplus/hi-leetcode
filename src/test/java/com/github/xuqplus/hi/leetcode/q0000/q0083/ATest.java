package com.github.xuqplus.hi.leetcode.q0000.q0083;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 删除排序链表中的重复元素
 * easy
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        ListNode node = new ListNode();
        node.val = 1;
        node.next = new ListNode(1, new ListNode(2));
        log.info("{}", solution.deleteDuplicates(node));
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode r = head;
        while (null != r && null != r.next) {
            if (r.val == r.next.val) {
                r.next = r.next.next;
            } else {
                r = r.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
