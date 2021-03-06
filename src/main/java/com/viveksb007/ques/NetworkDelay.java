package com.viveksb007.ques;

import java.util.*;

public class NetworkDelay {

    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int[][] times = new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        int maxTime = networkDelay.floydWarshall(times, n, k); // O(V^3)
        System.out.println("Floyd Warshall : " + maxTime);  // 2
        maxTime = networkDelay.dijkstra(times, n, k); // O(E Log(V))
        System.out.println("Dijkstra : " + maxTime);
        maxTime = networkDelay.bellmanFord(times, n, k); // O(VE)
        System.out.println("Bellman Ford : " + maxTime);
    }

    private int floydWarshall(int[][] times, int n, int k) {
        int[][] dis = new int[n][n];
        for (int[] d : dis)
            Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            dis[i][i] = 0;
        for (int[] time : times)
            dis[time[0] - 1][time[1] - 1] = time[2];

        int x, y, z;
        for (x = 0; x < n; x++) {
            for (y = 0; y < n; y++) {
                for (z = 0; z < n; z++) {
                    if (dis[y][x] != Integer.MAX_VALUE && dis[x][z] != Integer.MAX_VALUE && dis[y][z] > dis[y][x] + dis[x][z])
                        dis[y][z] = dis[y][x] + dis[x][z];
                }
            }
        }

        int max = 0;
        for (int a : dis[k - 1]) {
            if (a == Integer.MAX_VALUE) return -1;
            max = Math.max(max, a);
        }
        return max;
    }

    private int dijkstra(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] time : times) {
            graph[time[0]].add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n + 1];
        q.add(new int[]{0, k});
        while (!q.isEmpty()) {
            int[] node = q.remove();
            int distance = node[0];
            int u = node[1];
            if (visited[u]) continue;
            visited[u] = true;
            for (int[] neighbour : graph[u]) {
                q.add(new int[]{distance + neighbour[1], neighbour[0]});
            }
            n--;
            if (n == 0)
                return distance;
        }
        return -1;
    }

    private int bellmanFord(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for (int i = 1; i < n; i++) {
            boolean change = false;
            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
                    dist[v] = dist[u] + w;
                    change = true;
                }
            }
            if (!change)
                break;
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        return (max == Integer.MAX_VALUE) ? -1 : max;
    }

}
