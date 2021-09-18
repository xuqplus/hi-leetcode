package com.github.xuqplus.hi.leetcode.q0000.q0021;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
@Slf4j
public class ATest {

    @Test
    void a() throws JSONException {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(3)));
        ListNode l2 = new ListNode(2, new ListNode(4));
        ListNode listNode = new ListNode();
        listNode.val = 0;
        listNode.next = l2;
        log.info("{}", solution.mergeTwoLists(l1, listNode));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode result, curr;
        if (l1.val <= l2.val) {
            curr = result = l1;
            l1 = l1.next;
        } else {
            curr = result = l2;
            l2 = l2.next;
        }
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = null != l1 ? l1 : l2;
        return result;
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

    @Override
    public String toString() {
        if (null != next) {
            return val + "," + next.toString();
        }
        return val + "";
    }
}
