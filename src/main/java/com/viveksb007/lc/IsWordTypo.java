package com.viveksb007.lc;

import java.util.*;

//https://leetcode.com/discuss/interview-question/679321/google-onsite-determine-if-word-is-typo-because-of-stuck-key
// todo : solve by creating a Trie and searching at dispersing paths
public class IsWordTypo {

    public static void main(String[] args) {
        IsWordTypo typo = new IsWordTypo();
        List<String> dict = Arrays.asList("hello", "cat", "world", "dog", "bird", "grass", "green", "help", "greet", "great");
        String word = "bbbirrrdddd";
        boolean isTypo = typo.isTypeBecauseStuckKey(word, dict);
        System.out.println(isTypo);
        System.out.println(typo.isTypeBecauseStuckKey("gggraasssa", dict));
    }

    private Set<String> set;

    private boolean isTypeBecauseStuckKey(String word, List<String> dict) {
        set = new HashSet<>(dict);
        return fn("", word);
    }

    private boolean fn(String intermediate, String str) {
        if ("".equals(str)) {
            return set.contains(intermediate);
        }
        if ("".equals(intermediate)) {
            return fn(str.substring(0, 1), str.substring(1));
        }
        int last = intermediate.length() - 1;
        if (intermediate.charAt(last) == str.charAt(0)) {
            return fn(intermediate + str.charAt(0), str.substring(1)) ||
                    fn(intermediate, str.substring(1));
        }
        return fn(intermediate + str.charAt(0), str.substring(1));
    }

}
