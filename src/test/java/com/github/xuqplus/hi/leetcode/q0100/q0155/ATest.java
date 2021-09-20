package com.github.xuqplus.hi.leetcode.q0100.q0155;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 最小栈
 * easy
 * https://leetcode-cn.com/problems/min-stack/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        MinStack solution = new MinStack();
        log.info("{}", solution);
    }
}

class MinStack {

    final Stack<Integer> stack = new Stack();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.lastElement();
    }

    public int getMin() {
        int r = Integer.MAX_VALUE;
        for (Integer v : stack) {
            r = Math.min(r, v);
        }
        return r;
    }
}
