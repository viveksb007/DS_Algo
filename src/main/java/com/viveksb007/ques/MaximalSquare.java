package com.viveksb007.ques;

public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int area = maximalSquare.solve(matrix);
        System.out.println(area); // 4
        matrix = new char[][]{
                {'1', '0'},
                {'1', '0'}
        };
        area = maximalSquare.solve(matrix);
        System.out.println(area); // 1
    }

    private int solve(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows + 1][cols + 1];
        int i, j;
        for (i = 1; i <= rows; i++) {
            prefixSum[i][1] = prefixSum[i - 1][1] + (matrix[i - 1][0] == '1' ? 1 : 0);
        }
        for (i = 1; i <= cols; i++) {
            prefixSum[1][i] = prefixSum[1][i - 1] + (matrix[0][i - 1] == '1' ? 1 : 0);
        }
        for (i = 2; i <= rows; i++) {
            for (j = 2; j <= cols; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + (matrix[i - 1][j - 1] == '1' ? 1 : 0);
            }
        }

//        Arrays.stream(prefixSum).forEach(a -> System.out.println(Arrays.toString(a)));

        int max = 0;
        for (i = 1; i <= rows; i++) {
            for (j = 1; j <= cols; j++) {
                int x = i, y = j;
                while (x <= rows && y <= cols) {
                    int sum = prefixSum[x][y] - prefixSum[x][j - 1] - prefixSum[i - 1][y] + prefixSum[i - 1][j - 1];
//                    System.out.println(sum);
                    if (sum == Math.pow(x - i + 1, 2)) {
                        max = Math.max(sum, max);
                    }
                    x++;
                    y++;
                }
            }
        }
        return max;
    }

}
