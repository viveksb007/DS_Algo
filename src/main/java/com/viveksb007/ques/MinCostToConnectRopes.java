package com.viveksb007.ques;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectRopes {

    public static void main(String[] args) {
        MinCostToConnectRopes minCostToConnectRopes = new MinCostToConnectRopes();
        int[] ropes = {8, 4, 6, 12};
        int minCost = minCostToConnectRopes.solve(ropes);
        System.out.println(minCost); // 58
    }

    private int solve(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i : ropes) pq.add(i);
        int cost = 0;
        while (pq.size() != 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += (min1 + min2);
            pq.add(min1 + min2);
        }
        return cost;
    }

}
