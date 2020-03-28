package com.viveksb007.ques;

// https://leetcode.com/problems/knight-dialer/
public class KnightDialer {

    private int[][] path = new int[][]{
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}
    };

    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();
        int sol = knightDialer.solve(3);
        System.out.println(sol);
    }

    private int solve(int n) {
        int[][] dp = new int[10][n];
        for (int i = 0; i < 10; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int p = 0; p < path[j].length; p++) {
                    sum += dp[path[j][p]][i - 1];
                }
                dp[j][i] = sum;
            }
        }
        int sol = 0;
        for (int i = 0; i < 10; i++) {
            sol += dp[i][n - 1];
        }
        return sol;
    }

}
