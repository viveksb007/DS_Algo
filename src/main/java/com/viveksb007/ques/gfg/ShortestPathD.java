package com.viveksb007.ques.gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n/0
public class ShortestPathD {

    public static void main(String[] args) throws IOException {
        ShortestPathD shortestPathD = new ShortestPathD();
        shortestPathD.solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer>[] graph = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                if (i + 1 <= n)
                    graph[i].add(i + 1);
                if (3 * i <= n)
                    graph[i].add(3 * i);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.offer(new int[]{0, 1});
            while (!pq.isEmpty()) {
                int[] path = pq.remove();
                int distance = path[0];
                int node = path[1];
                if (node == n) {
                    pw.println(distance);
                    break;
                }
                for (int i : graph[node]) {
                    pq.offer(new int[]{distance + 1, i});
                }
            }
        }
        pw.close();
    }

}
