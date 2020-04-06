package com.viveksb007.ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

//https://leetcode.com/problems/critical-connections-in-a-network/
//https://www.geeksforgeeks.org/bridge-in-a-graph/
// Finding bridges in a network, bridge is an edge if removed disconnects the graph
public class CriticalConnectionsInNetwork {

    private int time = 0;
    private List<List<Integer>> bridges = new ArrayList<>();

    public static void main(String[] args) {
        CriticalConnectionsInNetwork criticalConnectionsInNetwork = new CriticalConnectionsInNetwork();
        int n = 4;
        List<List<Integer>> connections = asList(
                asList(0, 1),
                asList(1, 2),
                asList(2, 0),
                asList(1, 3)
        );
        List<List<Integer>> bridges = criticalConnectionsInNetwork.solve(n, connections);
        System.out.println(bridges); // [[1,3]] or [[3,1]]
    }

    private List<List<Integer>> solve(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                parent[i] = -1;
                dfs(graph, i, parent, disc, low, visited);
            }
        }
        return bridges;
    }

    private void dfs(List<Integer>[] graph, int u, int[] parent, int[] disc, int[] low, boolean[] visited) {
        disc[u] = time;
        low[u] = time;
        time++;
        visited[u] = true;
        for (int i = 0; i < graph[u].size(); i++) {
            int v = graph[u].get(i);
            if (!visited[v]) {
                parent[v] = u;
                dfs(graph, v, parent, disc, low, visited);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }

            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }

}
