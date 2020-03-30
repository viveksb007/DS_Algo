package com.viveksb007.ques.gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class StepsByKnight {

    public static void main(String[] args) throws IOException {
        StepsByKnight stepsByKnight = new StepsByKnight();
        stepsByKnight.solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[] r = new int[]{-2, -1, -2, -1, 2, 1, 2, 1};
        int[] c = new int[]{-1, -2, 1, 2, -1, -2, 1, 2};
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] inp = reader.readLine().split(" ");
            Queue<Coordinate> queue = new LinkedList<>();
            Set<Coordinate> visited = new HashSet<>();
            Coordinate knight = new Coordinate(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
            queue.add(knight);
            queue.add(null);
            visited.add(knight);
            inp = reader.readLine().split(" ");
            Coordinate target = new Coordinate(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
            int level = 0;
            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.remove();
                if (coordinate == null) {
                    level++;
                    if (!queue.isEmpty())
                        queue.add(null);
                } else {
                    if (coordinate.equals(target)) {
                        pw.println(level);
                        break;
                    } else {
                        int x = coordinate.x;
                        int y = coordinate.y;
                        for (int i = 0; i < 8; i++) {
                            if (x + r[i] > 0 && x + r[i] <= n && y + c[i] > 0 && y + c[i] <= n) {
                                Coordinate nextCoordinate = new Coordinate(x + r[i], y + c[i]);
                                if (!visited.contains(nextCoordinate)) {
                                    queue.add(nextCoordinate);
                                    visited.add(nextCoordinate);
                                }
                            }
                        }
                    }
                }
            }
        }
        pw.close();
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordinate c = (Coordinate) obj;
            return this.x == c.x && this.y == c.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
