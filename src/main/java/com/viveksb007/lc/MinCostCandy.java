package com.viveksb007.lc;

// https://leetcode.com/discuss/interview-question/509316/DEShaw-India-Online-Assessment

import java.util.Arrays;

public class MinCostCandy {

    public static void main(String[] args) {
        MinCostCandy minCostCandy = new MinCostCandy();
        int[] candies = new int[]{1, 2, 3, 4};
        int cAdd = 2;
        int cRemove = 1;
        System.out.println(minCostCandy.solve(candies, cAdd, cRemove));
    }

    private int solve(int[] candies, int cAdd, int cRemove) {
        int totalCandies = 0, candiesRemoved = 0, i, n = candies.length;
        Arrays.sort(candies);
        for (i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        int minCost = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            int currentCandy = candies[i];
            totalCandies -= currentCandy;
            int addCandyCost = (i * currentCandy - candiesRemoved) * cAdd;
            int removeCandyCost = (totalCandies - ((n - 1 - i) * currentCandy)) * cRemove;
            minCost = Math.min(minCost, addCandyCost + removeCandyCost);
            candiesRemoved += candies[i];
        }
        return minCost;
    }

}
