package com.viveksb007.ques;

import java.util.Arrays;

public class GenerateSquareMatrix {

    public static void main(String[] args) {
        GenerateSquareMatrix generateSquareMatrix = new GenerateSquareMatrix();
        int[][] matrix = generateSquareMatrix.solve(4);
        Arrays.stream(matrix).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    private int[][] solve(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int i, k = 0, l = 0, x = n, y = n;
        while (k < x && l < y) {
            for (i = l; i < y; i++) {
                matrix[k][i] = count++;
            }
            k++;
            for (i = k; i < x; i++) {
                matrix[i][y - 1] = count++;
            }
            y--;

            if (k < x) {
                for (i = y - 1; i >= l; i--) {
                    matrix[x - 1][i] = count++;
                }
                x--;
            }

            if (l < y) {
                for (i = x - 1; i >= k; i--) {
                    matrix[i][l] = count++;
                }
                l++;
            }
        }
        return matrix;
    }

}
