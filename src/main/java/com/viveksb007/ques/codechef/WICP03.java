package com.viveksb007.ques.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WICP03 {

    public static void main(String[] args) {
        WICP03 wicp03 = new WICP03();
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int th = reader.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextLong();
            }
            Tuple sol = wicp03.solve(arr, th);
            System.out.println(sol.a + " " + sol.b);
        }
    }

    private Tuple solve(long[] arr, int threshold) {
        Arrays.sort(arr);
        long low = Integer.MIN_VALUE;
        long high = Integer.MAX_VALUE;
        long mid;
        long tSum;
        long sol = 0;
        long element = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            tSum = 0;
            for (long l : arr) {
                tSum += Math.max(l - mid, 0);
            }
            if (tSum >= threshold) {
                sol = tSum;
                element = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new Tuple(element, sol);
    }

    static class Tuple {
        long a;
        long b;

        Tuple(long a, long b) {
            this.a = a;
            this.b = b;
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
