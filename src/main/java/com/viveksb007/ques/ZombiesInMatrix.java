package com.viveksb007.ques;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

public class ZombiesInMatrix {

    private int[] r = new int[]{1, 0, -1, 0};
    private int[] c = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        ZombiesInMatrix zombiesInMatrix = new ZombiesInMatrix();
        List<List<Integer>> grid = asList(
                asList(1, 0, 0, 0, 1),
                asList(0, 0, 0, 0, 0),
                asList(0, 0, 0, 0, 0),
                asList(1, 0, 0, 0, 1));
        System.out.println(zombiesInMatrix.minHours(grid));
    }

    private int minHours(List<List<Integer>> grid) {
        int rows = grid.size();
        int columns = grid.get(0).size();
        int i, j;
        Queue<Pair> q = new LinkedList<>();
        boolean foundZombie = false;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new Pair(i, j));
                    foundZombie = true;
                }
            }
        }
        if (!foundZombie) {
            return -1;
        }
        int level = 0;
        q.add(null);
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            if (pair == null) {
                if (!q.isEmpty()) {
                    level++;
                    q.add(null);
                }
            } else {
                int x = pair.row;
                int y = pair.column;
                for (int p = 0; p < 4; p++) {
                    if (x + r[p] >= 0 && x + r[p] < rows && y + c[p] >= 0 && y + c[p] < columns && grid.get(x + r[p]).get(y + c[p]) == 0) {
                        grid.get(x + r[p]).set(y + c[p], 1);
                        q.add(new Pair(x + r[p], y + c[p]));
                    }
                }
            }
        }
        return level;
    }

    static class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
