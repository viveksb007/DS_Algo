package com.viveksb007.ques.codechef;

import java.io.PrintWriter;

public class ChefInFantasyLeague {

    public static void main(String[] args) {
        ChefInFantasyLeague cifl = new ChefInFantasyLeague();
        cifl.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int s = reader.nextInt();
            int[] p = new int[n];
            int i;
            for (i = 0; i < n; i++) {
                p[i] = reader.nextInt();
            }
            int[] type = new int[n];
            for (i = 0; i < n; i++) {
                type[i] = reader.nextInt();
            }
            int minD = Integer.MAX_VALUE;
            int minF = Integer.MAX_VALUE;
            for (i = 0; i < n; i++) {
                if (type[i] == 0) {
                    minD = Math.min(minD, p[i]);
                } else {
                    minF = Math.min(minF, p[i]);
                }
            }
            if ((minD != Integer.MAX_VALUE) && (minF != Integer.MAX_VALUE) && (s + minD + minF) <= 100)
                pw.println("yes");
            else
                pw.println("no");
        }
        pw.close();
    }

}
