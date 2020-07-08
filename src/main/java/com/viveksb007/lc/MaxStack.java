package com.viveksb007.lc;

import java.util.PriorityQueue;
import java.util.Stack;

// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/716-max-stack.html
public class MaxStack {

    final Stack<Node> stack;
    final PriorityQueue<Node> pq;

    public MaxStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val) {
                return 1;
            }
            return b.val - a.val;
        });
    }

    void push(int x) {
        Node node = new Node(x);
        stack.push(node);
        pq.add(node);
    }

    int pop() {
        if (stack.isEmpty())
            return -1;
        Node node = stack.pop();
        node.setInvalid();
        while (!stack.isEmpty() && !stack.peek().isValid) stack.pop();
        while (!pq.isEmpty() && !pq.peek().isValid) pq.poll();
        return node.val;
    }

    int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek().val;
    }

    int peekMax() {
        if (pq.isEmpty()) return -1;
        return pq.peek().val;
    }

    int popMax() {
        if (pq.isEmpty()) return -1;
        Node node = pq.poll();
        node.setInvalid();
        while (!stack.isEmpty() && !stack.peek().isValid) stack.pop();
        while (!pq.isEmpty() && !pq.peek().isValid) pq.poll();
        return node.val;
    }

    static class Node {
        int val;
        boolean isValid;

        Node(int val) {
            this.val = val;
            isValid = true;
        }

        void setInvalid() {
            this.isValid = false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", isValid=" + isValid +
                    '}';
        }
    }

}
