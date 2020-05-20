package com.viveksb007.dp;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        coinChange.solve(coins, amount);
    }

    private void solve(int[] coins, int amount) {
        System.out.println("Recursive with memo " + recursiveWithMemo(coins, amount, new int[amount]));
        System.out.println("Recursive " + recursive(coins, amount));
    }

    private int recursive(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int temp = recursive(coins, amount - coin);
                if (temp >= 0 && temp < min)
                    min = 1 + temp;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int recursiveWithMemo(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (dp[amount - 1] != 0) return dp[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int temp = recursiveWithMemo(coins, amount - coin, dp);
                if (temp >= 0 && temp < min)
                    min = 1 + temp;
            }
        }
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount - 1];
    }

}
