package com.viveksb007.ques.codechef;

import java.io.PrintWriter;

public class Covid {

    public static void main(String[] args) {
        Covid covid = new Covid();
        covid.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            boolean bad = false;
            int lastIndex = -20;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int temp = arr[i];
                if (temp == 1) {
                    if (i - lastIndex <= 5) {
                        bad = true;
                        break;
                    }
                    lastIndex = i;
                }
            }
            if (bad)
                pw.println("NO");
            else
                pw.println("YES");
        }
        pw.close();
    }

}
