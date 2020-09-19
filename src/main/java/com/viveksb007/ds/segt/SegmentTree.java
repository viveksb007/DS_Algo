package com.viveksb007.ds.segt;

import java.util.Arrays;

public class SegmentTree {

    private final MergeFunction<Integer, Integer, Integer> mergeFunction;
    private final Integer[] tree;

    public SegmentTree(Integer[] arr, MergeFunction<Integer, Integer, Integer> mergeFunction) {
        tree = new Integer[findArraySizeToRepresentTree(arr.length)];
        this.mergeFunction = mergeFunction;
        Arrays.fill(tree, null);
        createTree(arr);
    }

    public void updateElement(int index, int updatedValue, Integer[] arr) {
        updateElementUtil(0, arr.length - 1, index, updatedValue, 0, arr);
    }

    private int updateElementUtil(int start, int end, int updatedIndex, int updatedValue, int index, Integer[] arr) {
        if (updatedIndex < start || updatedIndex > end) return tree[index];
        if (start == end) {
            arr[updatedIndex] = updatedValue;
            tree[index] = updatedValue;
            return updatedValue;
        }
        int mid = (start + end) / 2;
        int l = updateElementUtil(start, mid, updatedIndex, updatedValue, 2 * index + 1, arr);
        int r = updateElementUtil(mid + 1, end, updatedIndex, updatedValue, 2 * index + 2, arr);
        tree[index] = mergeFunction.merge(l, r);
        return tree[index];
    }

    public Integer findQuery(int left, int right, Integer[] arr) {
        return findQueryUtil(0, 0, arr.length - 1, left, right);
    }

    private Integer findQueryUtil(int index, int start, int end, int left, int right) {
        if (start >= left && end <= right) return tree[index];
        if (end < left || start > right) return null;
        int mid = (start + end) / 2;
        Integer l = findQueryUtil(2 * index + 1, start, mid, left, right);
        Integer r = findQueryUtil(2 * index + 2, mid + 1, end, left, right);
        return mergeFunction.merge(l, r);
    }

    private void createTree(Integer[] arr) {
        createTreeUtil(0, 0, arr.length - 1, arr);
    }

    private int createTreeUtil(int index, int start, int end, Integer[] arr) {
        if (start == end) {
            tree[index] = arr[start];
            return tree[index];
        }
        int mid = (start + end) / 2;
        int l = createTreeUtil(2 * index + 1, start, mid, arr);
        int r = createTreeUtil(2 * index + 2, mid + 1, end, arr);
        tree[index] = mergeFunction.merge(l, r);
        return tree[index];
    }

    public static int findArraySizeToRepresentTree(int n) {
        double power = Math.log(n) / Math.log(2);
        if (((int) power) == power) return 2 * n - 1;
        int reqPower = (int) power + 1;
        return (int) Math.pow(2, reqPower) * 2 - 1;
    }

}
