package com.viveksb007.lc;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaxStackTest {

    @Test
    public void testMaxStack() {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(5);
        assertEquals(5, stack.top());
        stack.push(10);
        assertEquals(10, stack.peekMax());
        stack.push(9);
        assertEquals(10, stack.peekMax());
        stack.push(20);
        assertEquals(20, stack.peekMax());
        stack.pop();
        assertEquals(10, stack.peekMax());
        assertEquals(10, stack.popMax());
        assertEquals(9, stack.peekMax());
        assertEquals(9, stack.pop());
        assertEquals(5, stack.top());
        assertEquals(5, stack.popMax());
        assertEquals(1, stack.top());
        assertEquals(1, stack.pop());
        assertEquals(5, stack.peekMax());
        assertEquals(5, stack.popMax());
    }

}
