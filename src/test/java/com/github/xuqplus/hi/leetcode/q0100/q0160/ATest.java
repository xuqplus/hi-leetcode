package com.github.xuqplus.hi.leetcode.q0100.q0160;

import com.github.xuqplus.hi.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * easy
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        ListNode headA = new ListNode(1);
        log.info("{}", solution.getIntersectionNode(headA, headA));
    }
}

class Solution {

    static ListNode solution(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (null != headA) {
            set.add(headA);
            headA = headA.next;
        }
        while (null != headB) {
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }
        return null;
    }

    static ListNode solution2(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = null == a ? headB : a.next;
            b = null == b ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return solution2(headA, headB);
    }
}
