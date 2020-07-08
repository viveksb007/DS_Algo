package com.viveksb007.lc;

import java.util.PriorityQueue;
import java.util.Stack;

// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/716-max-stack.html
public class MaxStackPqImpl implements MaxStack {

    final Stack<Node> stack;
    final PriorityQueue<Node> pq;

    public MaxStackPqImpl() {
        stack = new Stack<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val) {
                return b.index - a.index;
            }
            return b.val - a.val;
        });
    }

    @Override
    public void push(int x) {
        Node node = new Node(x, stack.size());
        stack.push(node);
        pq.add(node);
    }

    @Override
    public int pop() {
        if (stack.isEmpty())
            return -1;
        Node node = stack.pop();
        node.setInvalid();
        while (!stack.isEmpty() && !stack.peek().isValid) stack.pop();
        while (!pq.isEmpty() && !pq.peek().isValid) pq.poll();
        return node.val;
    }

    @Override
    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek().val;
    }

    @Override
    public int peekMax() {
        if (pq.isEmpty()) return -1;
        return pq.peek().val;
    }

    @Override
    public int popMax() {
        if (pq.isEmpty()) return -1;
        Node node = pq.poll();
        node.setInvalid();
        while (!stack.isEmpty() && !stack.peek().isValid) stack.pop();
        while (!pq.isEmpty() && !pq.peek().isValid) pq.poll();
        return node.val;
    }

    @Override
    public int size() {
        return stack.size();
    }

    static class Node {
        int val;
        int index;
        boolean isValid;

        Node(int val, int index) {
            this.val = val;
            this.index = index;
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
