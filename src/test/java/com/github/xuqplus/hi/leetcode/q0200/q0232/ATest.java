package com.github.xuqplus.hi.leetcode.q0200.q0232;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 用栈实现队列
 * easy
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        MyQueue solution = new MyQueue();
        solution.push(1);
        solution.push(2);
        log.info("{}", solution.pop());

        ArrayDeque q1 = new ArrayDeque();
        LinkedList q2 = new LinkedList();
        q1.add(1);
        q1.add(2);
        q2.add(1);
        q2.add(2);
        log.info("{}", q1.pop());
        log.info("{}", q2.pop());
    }
}

class MyQueue {

    Stack<Integer> s0 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        s0.add(0, x);
    }

    public int pop() {
        return s0.pop();
    }

    public int peek() {
        return s0.peek();
    }

    public boolean empty() {
        return s0.isEmpty();
    }
}
