package com.viveksb007.ques;

import java.util.ArrayList;
import java.util.List;

// finding critical nodes, removing the node and its associated edges results in disconnected graph
// https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
public class CriticalConnections {

    private int time = 0;

    public static void main(String[] args) {
        CriticalConnections criticalConnections = new CriticalConnections();
        int numOfNodes = 7;
        int numOfEdges = 7;
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}
        };
        List<Integer> criticalNodes = criticalConnections.solve(numOfNodes, numOfEdges, edges);
        System.out.println(criticalNodes); // 2,3,5
    }

    private List<Integer> solve(int numOfNodes, int numOfEdges, int[][] edges) {
        List<Integer>[] graph = new List[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[numOfNodes];
        int[] parent = new int[numOfNodes];
        int[] disc = new int[numOfNodes];
        int[] low = new int[numOfNodes];
        boolean[] articulationPoint = new boolean[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            if (!visited[i]) {
                parent[i] = -1;
                dfs(graph, i, visited, parent, disc, low, articulationPoint);
            }
        }
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < articulationPoint.length; i++) {
            if (articulationPoint[i])
                sol.add(i);
        }
        return sol;
    }

    private void dfs(List<Integer>[] graph, int node, boolean[] visited, int[] parent, int[] disc, int[] low, boolean[] articulationPoint) {
        int children = 0;
        visited[node] = true;
        disc[node] = time;
        low[node] = time;
        time++;
        for (int i = 0; i < graph[node].size(); i++) {
            int v = graph[node].get(i);
            if (!visited[v]) {
                parent[v] = node;
                children++;
                dfs(graph, v, visited, parent, disc, low, articulationPoint);

                low[node] = Math.min(low[v], low[node]);

                if (parent[node] == -1 && children > 1) {
                    articulationPoint[node] = true;
                }
                if (parent[node] != -1 && low[v] >= disc[node]) {
                    articulationPoint[node] = true;
                }
            } else if (v != parent[node])
                low[node] = Math.min(disc[v], low[node]);
        }
    }

}
