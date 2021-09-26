package com.github.xuqplus.hi.leetcode.q0200.q0203;

import com.github.xuqplus.hi.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 移除链表元素
 * easy
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.removeElements(null, 1));
    }
}

class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (null != head && val == head.val) {
            head = head.next;
        }
        if (null == head) {
            return null;
        }
        ListNode l = head;
        while (null != l.next) {
            if (val == l.next.val) {
                l.next = l.next.next;
            } else {
                l = l.next;
            }
        }
        return head;
    }
}
