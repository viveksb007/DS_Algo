package com.viveksb007.ques.gfg;

import java.util.ArrayList;

public class DetectCycle {

    private static boolean hasCycle = false;

    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        hasCycle = false;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(list, vis, i);
            }
        }
        return hasCycle;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] vis, int n) {
        vis[n] = true;
        for (int i = 0; i < list.get(n).size(); i++) {
            int child = list.get(n).get(i);
            if (vis[child]) {
                hasCycle = true;
                return;
            } else {
                dfs(list, vis, child);
            }
        }
        vis[n] = false;
    }


}
