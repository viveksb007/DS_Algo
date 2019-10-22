package com.viveksb007.ques.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MDL {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int minVal = Integer.MAX_VALUE, minIndex = 0;
            int maxVal = Integer.MIN_VALUE, maxIndex = 0;
            for (int i = 0; i < n; i++) {
                int temp = reader.nextInt();
                if (temp < minVal) {
                    minVal = temp;
                    minIndex = i;
                }
                if (temp > maxVal) {
                    maxVal = temp;
                    maxIndex = i;
                }
            }
            if (minIndex < maxIndex) {
                System.out.println(minVal + " " + maxVal);
            } else {
                System.out.println(maxVal + " " + minVal);
            }
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
