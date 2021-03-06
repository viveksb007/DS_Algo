package com.viveksb007.ques.codechef;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BoxOfChocolates {

    public static void main(String[] args) {
        BoxOfChocolates boxOfChocolates = new BoxOfChocolates();
        boxOfChocolates.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int max = Integer.MIN_VALUE;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
                if (arr[i] > max)
                    max = arr[i];
            }
            List<Integer> maxIndexes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] == max)
                    maxIndexes.add(i);
            }
            maxIndexes.add(maxIndexes.get(0) + n);
            int count = 0;
            for (int i = 0; i < maxIndexes.size() - 1; i++) {
                count += Math.max(0, maxIndexes.get(i + 1) - maxIndexes.get(i) - (n / 2));
            }
            pw.println(count);
        }
        pw.close();
    }

}
