package com.viveksb007.lc;

public class LongestSubstringWithAtMostKDistinctChars {

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctChars ls = new LongestSubstringWithAtMostKDistinctChars();
        String str = "abcd";
        int k = 1;
        System.out.println(ls.solve(str, k));
    }

    private int solve(String str, int k) {
        int[] hash = new int[256];
        int start = 0, end = 0, distinctChars = 0, maxLength = 0;
        while (end < str.length()) {
            if (hash[str.charAt(end)] == 0) {
                distinctChars++;
            }
            hash[str.charAt(end)]++;
            end++;
            while (distinctChars > k) {
                hash[str.charAt(start)]--;
                if (hash[str.charAt(start)] == 0) distinctChars--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

}
