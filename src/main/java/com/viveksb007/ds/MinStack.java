package com.viveksb007.ds;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack;
    private int minEle;

    MinStack() {
        stack = new Stack<>();
    }

    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minEle = x;
        } else if (x >= minEle) {
            stack.push(x);
        } else {
            stack.push(2 * x - minEle);
            minEle = x;
        }
    }

    int pop() {
        if (stack.isEmpty()) return -1;
        int x = stack.pop();
        if (x < minEle) {
            int temp = minEle;
            minEle = 2 * minEle - x;
            return temp;
        }
        return x;
    }

    int getMinimum() {
        return minEle;
    }


}
