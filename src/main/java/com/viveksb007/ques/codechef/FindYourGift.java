package com.viveksb007.ques.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FindYourGift {

    public static void main(String[] args) {
        FindYourGift findYourGift = new FindYourGift();
        findYourGift.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        PrintWriter pw = new PrintWriter(System.out);
        while (t-- > 0) {
            int n = reader.nextInt();
            String str = reader.nextLine();
            char prev = '1';
            int x = 0, y = 0;
            for (char c : str.toCharArray()) {
                switch (c) {
                    case 'L':
                        if (prev == 'L' || prev == 'R')
                            continue;
                        x--;
                        break;
                    case 'R':
                        if (prev == 'L' || prev == 'R')
                            continue;
                        x++;
                        break;
                    case 'U':
                        if (prev == 'U' || prev == 'D')
                            continue;
                        y++;
                        break;
                    case 'D':
                        if (prev == 'U' || prev == 'D')
                            continue;
                        y--;
                }
                prev = c;
            }
            pw.println(x + " " + y);
        }
        pw.close();
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
