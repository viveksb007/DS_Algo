package com.viveksb007.lc;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaxStackTest {

    @Test
    public void testMaxStackPqImpl() {
        MaxStackPqImpl stack = new MaxStackPqImpl();
        test(stack);
    }

    private void test(MaxStackPqImpl stack) {
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
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        assertEquals(10, stack.peekMax());
        assertEquals(7, stack.top());
        assertEquals(10, stack.popMax());
        assertEquals(10, stack.peekMax());
        assertEquals(7, stack.pop());
        assertEquals(8, stack.top());
        assertEquals(8, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(10, stack.peekMax());
        assertEquals(10, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        assertEquals(10, stack.popMax());
        assertEquals(6, stack.size());
        assertEquals(10, stack.popMax());
        assertEquals(5, stack.size());
        assertEquals(10, stack.popMax());
        assertEquals(4, stack.size());
        assertEquals(10, stack.popMax());
        assertEquals(3, stack.size());
        stack.pop();
        stack.pop();
        assertEquals(10, stack.peekMax());
        assertEquals(10, stack.popMax());
        assertEquals(0, stack.size());
    }

}
