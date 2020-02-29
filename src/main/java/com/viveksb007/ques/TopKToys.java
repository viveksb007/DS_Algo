package com.viveksb007.ques;

import java.util.*;

import static java.util.Arrays.asList;

public class TopKToys {

    public static void main(String[] args) {
        TopKToys topKToys = new TopKToys();
        int numToys = 6;
        int topToys = 2;
        List<String> toys = asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft");
        int numQuotes = 6;
        List<String> quotes = asList("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season");
        List<String> sol = topKToys.findTopK(numToys, topToys, toys, numQuotes, quotes);
        System.out.println(sol);
    }

    private List<String> findTopK(int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes) {
        Set<String> toySet = new HashSet<>(toys);
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> topToysQueue = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s1) > map.get(s2))
                return 1;
            if (map.get(s1).equals(map.get(s2)))
                return s1.compareTo(s2);
            return -1;
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
                    if (topToysQueue.size() > topToys) {
                        topToysQueue.remove();
                    } else if (!topToysQueue.contains(str))
                        topToysQueue.add(str);
                }
            }
        });
        List<String> topKToys = new ArrayList<>(topToysQueue);
        Collections.reverse(topKToys);
        return topKToys;
    }

}
