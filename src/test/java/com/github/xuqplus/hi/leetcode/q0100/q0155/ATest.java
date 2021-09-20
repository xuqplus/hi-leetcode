package com.github.xuqplus.hi.leetcode.q0100.q0155;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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

    static class Element {
        int val;
        int min;
    }

    int size = 0;
    Element[] data = new Element[16];

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        Element element = new Element();
        element.val = val;
        if (size == 0) {
            element.min = val;
        } else {
            element.min = Math.min(data[size - 1].min, val);
        }
        if (size >= data.length) {
            Element[] dataNew = new Element[data.length * 2];
            System.arraycopy(data, 0, dataNew, 0, size);
            data = dataNew;
        }
        data[size++] = element;
    }

    public void pop() {
        if (size > 0)
            size--;
    }

    public int top() {
        if (size > 0)
            return data[size - 1].val;
        return 0;
    }

    public int getMin() {
        if (size > 0)
            return data[size - 1].min;
        return 0;
    }
}
