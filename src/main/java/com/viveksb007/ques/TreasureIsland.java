package com.viveksb007.ques;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

public class TreasureIsland {

    public static void main(String[] args) {
        TreasureIsland treasureIsland = new TreasureIsland();
        List<List<Character>> island = asList(
                asList('O', 'O', 'O', 'O'),
                asList('D', 'O', 'D', 'O'),
                asList('O', 'O', 'O', 'O'),
                asList('X', 'D', 'D', 'O'));
        int steps = treasureIsland.solve(island);
        System.out.println(steps);
    }

    private int solve(List<List<Character>> island) {
        int rows = island.size();
        int cols = island.get(0).size();
        int[] r = new int[]{1, -1, 0, 0};
        int[] c = new int[]{0, 0, 1, -1};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] coordinate = q.remove();
                int x = coordinate[0];
                int y = coordinate[1];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + r[j];
                    int nextY = y + c[j];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                        if (!visited[nextX][nextY] && island.get(nextX).get(nextY) == 'O') {
                            visited[nextX][nextY] = true;
                            q.add(new int[]{nextX, nextY});
                        } else if (island.get(nextX).get(nextY) == 'X')
                            return level;
                    }
                }
            }
        }
        return -1;
    }

}
