package com.viveksb007.ques.gfg;

public class GCD {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int sol = gcd.findGCD(Math.abs(-4), Math.abs(-7));
        System.out.println(sol);
    }

    private int findGCD(int a, int b) {
        if (b > a) return findGCD(b, a);
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

}
