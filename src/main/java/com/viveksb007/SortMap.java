package com.viveksb007;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 1);
        map.put("asdf", 4);
        map.put("fdsa", 2);
        System.out.println(map);
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        System.out.println(sortedMap);
    }

}
