package com.viveksb007.lc;

import java.util.Arrays;

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        KClosestPointToOrigin origin = new KClosestPointToOrigin();
        int[][] points = new int[][]{
                {0, 1}, {1, 0}
        };
        int[][] sol = origin.kClosest(points, 2);
        Arrays.stream(sol).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public int[][] kClosest(int[][] points, int K) {
        sort(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void sort(int[][] points, int start, int end, int k) {
        if (start >= end) return;
        int pivot = partition(points, start, end);
        if (k < pivot) sort(points, start, pivot - 1, k);
        if (k > pivot) sort(points, pivot + 1, end, k);
    }

    private int partition(int[][] points, int start, int end) {
        int pivotDistance = dist(points, end);
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (dist(points, j) < pivotDistance) {
                i++;
                swap(points, i, j);
            }
        }
        i++;
        swap(points, i, end);
        return i;
    }

    private int dist(int[][] points, int i) {
        int[] point = points[i];
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int tx = points[i][0];
        int ty = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = tx;
        points[j][1] = ty;
    }


}
