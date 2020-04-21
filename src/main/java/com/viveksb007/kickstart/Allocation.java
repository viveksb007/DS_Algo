package com.viveksb007.kickstart;

import com.viveksb007.ques.codechef.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class Allocation {

    public static void main(String[] args) {
        Allocation allocation = new Allocation();
        allocation.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        int count = 0;
        while (t-- > 0) {
            int n = reader.nextInt();
            int budget = reader.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = reader.nextInt();
            Arrays.sort(arr);
            int temp = 0;
            int house = 0;
            for (int i = 0; i < n; i++) {
                if (temp + arr[i] <= budget) {
                    temp += arr[i];
                    house++;
                } else
                    break;
            }
            pw.println(String.format("Case #%d: %d", ++count, house));
        }
        pw.close();
    }

}
