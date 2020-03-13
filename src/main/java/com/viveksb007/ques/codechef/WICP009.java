package com.viveksb007.ques.codechef;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WICP009 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Reader.init(System.in);
        int t = Reader.nextInt();
        while (t-- > 0) {
            int n = Reader.nextInt();
            char[][] arr = new char[n][n];
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = Reader.next();
                arr[i] = s[i].toCharArray();
            }
            int[] col = findFirstStoneInCol(arr, n);
            int[] row = findFirstStoneInRow(arr, n);
            int ans = countMirrorCells(col, row, n);
            pw.println(ans);
        }
        pw.close();
    }

    private static int[] findFirstStoneInRow(char[][] arr, int n) {
        int[] b = new int[n];
        Arrays.fill(b, -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] == '#') {
                    b[i] = j;
                    break;
                }
            }
        }
        return b;
    }

    private static int[] findFirstStoneInCol(char[][] arr, int n) {
        int[] a = new int[n];
        Arrays.fill(a, -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] == '#') {
                    a[i] = j;
                    break;
                }
            }
        }
        return a;
    }

    private static int countMirrorCells(int[] col, int[] row, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (col[j] < i && row[i] < j) count++;
            }
        }
        return count;
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
