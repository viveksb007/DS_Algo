package com.viveksb007.kickstart;

import com.viveksb007.ques.codechef.FastReader;

import java.io.PrintWriter;

public class BikeTour {

    public static void main(String[] args) {
        BikeTour bikeTour = new BikeTour();
        bikeTour.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        int count = 1;
        while (t-- > 0) {
            int n = reader.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                    ans++;
            }
            pw.println(String.format("Case #%d:%d", count++, ans));
        }
        pw.close();
    }

}
