package com.viveksb007.ques;

/*

https://leetcode.com/discuss/interview-experience/539590/amazon-new-grad-vancouver-offer

 * Given a list of words, print all words which has components (words too) of itself in the list.
 * For example - and input of [rockstar, rocks, stars, rock, super, high, way, highways, superhigh]
 * would yield output - superhigh = super + high. and nothing else.
 * I was stumped at first but I quickly arrived at a brute force n^3 solution.
 * Thereafter, I got lost quite a few times but kept talking.
 * My interviewer gave me a lot of hints and a lot of direction for this question
 * I think and in the end I wrote a good piece of code for it and he was happy.
 * I felt that if I get a rejection, it would probably be because of this interview since it felt as if I didn't arrive at the optimal solution myself.
 * */

import java.util.*;

public class WordBreak {

    private String underConsideration;

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String[] input = new String[]{"rockstar", "rocks", "stars", "rock", "super", "high", "way", "highways", "superhigh", "t", "ar", "waytar"};
        wordBreak.solve(input);
    }

    private void solve(String[] input) {
        Set<String> words = new HashSet<>(Arrays.asList(input));
        List<String> sol = new ArrayList<>();
        for (String str : input) {
            underConsideration = str;
            if (hasComponents(str, words)) {
                sol.add(str);
            }
        }
        System.out.println(sol);
    }

    private boolean hasComponents(String str, Set<String> words) {
        if ("".equals(str)) return false;
        StringBuilder sb = new StringBuilder();
        boolean sol = false;
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (words.contains(sb.toString())) {
                if (i < str.length() - 1)
                    sol |= hasComponents(str.substring(i + 1), words);
                else if (!underConsideration.equals(str))
                    return true;
            }
        }
        return sol;
    }

}
