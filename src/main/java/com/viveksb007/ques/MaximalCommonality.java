package com.viveksb007.ques;

public class MaximalCommonality {

    public static void main(String[] args) {
        MaximalCommonality maximalCommonality = new MaximalCommonality();
//        {
//            "cccybby" -> 2
//            "abcdedeara" -> 3
//        }
        String input = "abcdedeara";
        int sol = maximalCommonality.solve(input);
        System.out.println(sol);
        int fundoSolve = maximalCommonality.fundoSolve(input);
        System.out.println("Using fundo sol " + fundoSolve);
    }

    // Amazing thinking by https://leetcode.com/popeye_the_sailort
    private int fundoSolve(String input) {
        int[] frequency = new int[26];
        for (char c : input.toCharArray())
            frequency[c - 'a']++;
        int sol = 0;
        int commonality = 0;
        for (char c : input.toCharArray()) {
            if (frequency[c - 'a'] > 1) {
                commonality++;
                frequency[c - 'a'] -= 2;
            } else if (frequency[c - 'a'] == 0) {
                commonality--;
            } else {
                frequency[c - 'a']--;
            }
            if (commonality > sol)
                sol = commonality;
        }
        return sol;
    }

    private int solve(String input) {
        int[] lc = new int[26];
        int[] rc = new int[26];
        for (char c : input.toCharArray()) {
            rc[c - 'a']++;
        }
        int max = 0;
        for (char c : input.toCharArray()) {
            lc[c - 'a']++;
            rc[c - 'a']--;
            int res = findCommonality(lc, rc);
            if (res > max)
                max = res;
        }
        return max;
    }

    private int findCommonality(int[] lc, int[] rc) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.min(lc[i], rc[i]);
        }
        return count;
    }

}
