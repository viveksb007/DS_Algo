package com.viveksb007.ques;

import java.util.*;

import static java.util.Arrays.asList;

public class TopKToys {

    public static void main(String[] args) {
        TopKToys topKToys = new TopKToys();
        int numToys = 6;
        int topToys = 2;
        List<String> toys = asList("anacell", "cetracular", "betacellular");
        int numQuotes = 6;
        List<String> quotes = asList("Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell");
        List<String> sol = topKToys.findTopK(numToys, topToys, toys, numQuotes, quotes);
        System.out.println(sol);
    }

    private List<String> findTopK(int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes) {
        Set<String> toySet = new HashSet<>(toys);
        Map<String, Integer> map = new HashMap<>();
        TreeSet<String> topToysSet = new TreeSet<>((s1, s2) -> {
            if (map.get(s1).equals(map.get(s2)))
                return s2.compareTo(s1);
            return map.get(s1) - map.get(s2);
        });
        quotes.forEach(quote -> {
            String[] s = quote.split(" ");
            Set<String> tempSet = new HashSet<>();
            for (String str : s) {
                tempSet.add(str.toLowerCase());
            }
            for (String str : tempSet) {
                if (toySet.contains(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
        });
        topToysSet.addAll(map.keySet());
        while (topToysSet.size() != topToys)
            topToysSet.pollFirst();
        List<String> l = new ArrayList<>(topToysSet);
        Collections.reverse(l);
        return l;
    }

}
