package com.github.xuqplus.hi.leetcode.q0200.q0206;

import com.github.xuqplus.hi.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 反转链表
 * easy
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        ListNode r = solution.reverseList(head);
        log.info("{}", r);
    }
}

class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        while (null != head) {
            if (null == head.next) {
                head.next = next;
                break;
            }
            ListNode h = head;
            ListNode hn = head.next;
            head.next = next;
            head = hn;
            next = h;
        }
        return head;
    }
}
