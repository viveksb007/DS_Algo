package com.viveksb007.algo;

public class RabinKarpAlgo {

    public boolean find(String string, String pattern) {
        if (pattern.length() > string.length()) return false;
        long base = 26;
        long prime = (1 << 31) - 1;
        long multiplier = 1;
        for (int i = 0; i < pattern.length() - 1; i++) {
            multiplier = (multiplier * base) % prime;
        }
        long patternHash = 0;
        long strHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % prime;
            strHash = (strHash * base + string.charAt(i)) % prime;
        }
        int end = pattern.length(), start = 0;
        while (end <= string.length()) {
            if (patternHash == strHash) {
                System.out.println("Pattern starting at index " + start);
                return pattern.equals(string.substring(start, end));
            }
            if (end < string.length()) {
                strHash = strHash - string.charAt(start++) * multiplier;
                strHash = strHash * base + string.charAt(end);
            }
            end++;
        }
        System.out.println("Pattern not found");
        return false;
    }
}
