package com.viveksb007.ques.gfg;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 25, 28, 16};
        int[] res = findNGE(arr);
        System.out.println(Arrays.toString(res));
    }

    static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    res[stack.pop()] = arr[i];
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

}
