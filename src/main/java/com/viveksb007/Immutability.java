package com.viveksb007;

import java.util.HashMap;
import java.util.Map;

public final class Immutability {

    private final String id;
    private final int val;
    private final HashMap<String, String> map;

    Immutability(String id, int val, HashMap<String, String> map) {
        this.id = id;
        this.val = val;
        this.map = (HashMap<String, String>) map.clone();
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        String yoman = "yoman";
        int val = 101;
        Immutability immutability = new Immutability(yoman, val, map);
        System.out.println("Before changing " + immutability.toString());
        val = 404;
        yoman = "asdfas";
        map.put("three", "3");
        System.out.println("After changing " + immutability.toString());
    }

    public Map<String, String> getMap() {
        return (HashMap<String, String>) this.map.clone();
    }

    public String getId() {
        return id;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "Immutability{" +
                "id='" + id + '\'' +
                ", val=" + val +
                ", map=" + map +
                '}';
    }

}
