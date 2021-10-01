package com.github.xuqplus.hi.leetcode.q0200.q0234;

import com.github.xuqplus.hi.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 回文链表
 * easy
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        log.info("{}", solution.isPalindrome(head));
    }

    @Test
    void a1() {
        {
            Solution solution = new Solution();
            ListNode head = new ListNode(0);
            ListNode n0 = new ListNode(1);
            head.next = n0;
            log.info("{}", solution.isPalindrome(head));
        }
        {
            Solution solution = new Solution();
            ListNode head = new ListNode(0);
            ListNode n0 = new ListNode(0);
            head.next = n0;
            log.info("{}", solution.isPalindrome(head));
        }
    }

    @Test
    void a2() {
        {
            Solution solution = new Solution();
            ListNode head = new ListNode(0);
            ListNode n0 = new ListNode(1);
            ListNode n1 = new ListNode(2);
            head.next = n0;
            n0.next = n1;
            log.info("{}", solution.isPalindrome(head));
        }
        {
            Solution solution = new Solution();
            ListNode head = new ListNode(0);
            ListNode n0 = new ListNode(1);
            ListNode n1 = new ListNode(0);
            head.next = n0;
            n0.next = n1;
            log.info("{}", solution.isPalindrome(head));
        }
    }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        } else if (null == head.next) {
            return true;
        }
        ListNode last = null;
        ListNode n1 = head, n2 = head;
        boolean isOdd = true;
        while (null != n2.next) {
            n2 = n2.next;
            ListNode t = n1;
            n1 = n1.next;
            t.next = last;
            last = t;
            isOdd = false;
            if (null != n2.next) {
                n2 = n2.next;
                isOdd = true;
            }
        }
        if (isOdd) {
            n1 = n1.next;
        }
        while (null != n1) {
            if (last.val != n1.val) {
                return false;
            }
            last = last.next;
            n1 = n1.next;
        }
        return true;
    }
}
