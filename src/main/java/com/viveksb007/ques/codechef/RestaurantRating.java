package com.viveksb007.ques.codechef;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class RestaurantRating {

    public static void main(String[] args) {
        RestaurantRating restaurantRating = new RestaurantRating();
        restaurantRating.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = reader.nextInt();
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            int type = reader.nextInt();
            switch (type) {
                case 1:
                    int element = reader.nextInt();
                    if ((minH.size() + maxH.size() + 1) / 3 > minH.size()) {
                        if (element > maxH.peek()) {
                            minH.add(element);
                        } else {
                            minH.add(maxH.remove());
                            maxH.add(element);
                        }
                    } else {
                        if (minH.size() > 0 && element > minH.peek()) {
                            maxH.add(minH.remove());
                            minH.add(element);
                        } else
                            maxH.add(element);
                    }
                    break;
                case 2:
                    if (minH.size() > 0) {
                        pw.println(minH.peek());
                    } else
                        pw.println("No reviews yet");

            }
        }
        pw.close();
    }

}
