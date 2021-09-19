package com.github.xuqplus.hi.leetcode.q0100.q0141;

import com.github.xuqplus.hi.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 环形链表
 * easy
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.hasCycle(null));
    }
}

class Solution {

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        // Set<ListNode> nodes = new HashSet<>();
        int val = 732910249;
        while (null != head.next) {
            if (val == head.next.val) {
                return true;
            }
            head = head.next;
            head.val = val;
        }
        return false;
    }
}
