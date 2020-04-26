package com.viveksb007.ques;

import java.util.Arrays;

public class PrefixSumMatrix {

    public static void main(String[] args) {
        PrefixSumMatrix prefixSumMatrix = new PrefixSumMatrix();
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        prefixSumMatrix.findPrefixSumMatrix(matrix);
        Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private void findPrefixSumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i, j;
        int sum = 0;
        for (i = 0; i < rows; i++) {
            sum += matrix[i][0];
            matrix[i][0] = sum;
        }
        sum = 0;
        for (i = 0; i < cols; i++) {
            sum += matrix[0][i];
            matrix[0][i] = sum;
        }
        for (i = 1; i < rows; i++) {
            for (j = 1; j < cols; j++) {
                matrix[i][j] += (matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1]);
            }
        }
    }

}
