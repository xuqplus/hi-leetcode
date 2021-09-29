package com.github.xuqplus.hi.leetcode.q0200.q0225;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用队列实现栈
 * easy
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        MyStack solution = new MyStack();
        log.info("{}", solution);
    }
}

class MyStack {

    LinkedList<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return queue.removeLast();
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
