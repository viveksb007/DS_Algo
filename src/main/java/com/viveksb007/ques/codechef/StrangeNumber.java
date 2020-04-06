package com.viveksb007.ques.codechef;

import java.io.PrintWriter;

public class StrangeNumber {

    public static void main(String[] args) {
        StrangeNumber strangeNumber = new StrangeNumber();
        strangeNumber.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = reader.nextInt();
        while (t-- > 0) {
            boolean found = false;
            int x = reader.nextInt();
            int k = reader.nextInt();
            if (k < x && k <= 30 && Math.pow(2, k) <= x) {
                if (Math.pow(2, k) == x) {
                    found = true;
                } else {
                    int primeDivisorCount = primeDivisorsCount(x);
                    if (primeDivisorCount >= k)
                        found = true;
                }
            }
            if (found)
                pw.println(1);
            else
                pw.println(0);
        }
        pw.close();
    }

    private int primeDivisorsCount(int n) {
        int count = 0;
        while (n % 2 == 0) {
            n = n / 2;
            count++;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                n /= i;
                count++;
            }
        }
        if (n > 2)
            count++;
        return count;
    }

    private int numberOfDivisors(int n) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count += 2;
            }
        }
        return count;
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

}
