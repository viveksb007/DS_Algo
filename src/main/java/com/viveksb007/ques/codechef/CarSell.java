package com.viveksb007.ques.codechef;

import java.io.PrintWriter;
import java.util.Arrays;

public class CarSell {

    public static void main(String[] args) {
        CarSell carSell = new CarSell();
        carSell.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        int max = (int) (Math.pow(10, 9) + 7);
        while (t-- > 0) {
            int n = reader.nextInt();
            Integer[] prices = new Integer[n];
            for (int i = 0; i < n; i++) prices[i] = reader.nextInt();
            Arrays.sort(prices, (a, b) -> b - a);
            int profit = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                profit = (profit % max + Math.max(prices[i] - count, 0) % max) % max;
                count++;
            }
            pw.println(profit);
        }
        pw.close();
    }

}
