package com.viveksb007.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberGuessing {

    private static final String CORRECT = "CORRECT";
    private static final String TOO_SMALL = "TOO_SMALL";
    private static final String TOO_BIG = "TOO_BIG";
    private static final String WRONG_ANSWER = "WRONG_ANSWER";

    public static void main(String[] args) {
        NumberGuessing numberGuessing = new NumberGuessing();
        numberGuessing.solve();
    }

    private void solve(FastReader reader, int lowerBound, int upperBound) {
        int average = ((upperBound - lowerBound) / 2) + lowerBound;
        System.out.println(average);
        String response = reader.next();
        switch (response) {
            case CORRECT:
                return;
            case TOO_BIG:
                solve(reader, lowerBound, average - 1);
                break;
            case TOO_SMALL:
                solve(reader, average + 1, upperBound);
                break;
            case WRONG_ANSWER:
                System.exit(0);
                break;
        }
    }

    private void solve() {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            int lowerBound, upperBound, numberOfGuesses;
            lowerBound = reader.nextInt();
            upperBound = reader.nextInt();
            numberOfGuesses = reader.nextInt();
            solve(reader, lowerBound, upperBound);
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
