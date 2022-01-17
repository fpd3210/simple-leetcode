package com.dpf.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author Pikachues
 * Created 2022/1/17
 */
public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int xMax = grid.length;
            int yMax = grid[0].length;

            int res = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < xMax; i++) {
                for (int j = 0; j < yMax; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        queue.add(i * yMax + j);
                        grid[i][j] = '0';
                        while (!queue.isEmpty()) {
                            int id = queue.poll();
                            int x = id / yMax;
                            int y = id % yMax;

                            if (y >= 0 && y < yMax) {
                                if (x - 1 >= 0 && x - 1 < xMax && grid[x - 1][y] == '1') {
                                    queue.add((x - 1) * yMax + y);
                                    grid[x - 1][y] = '0';
                                }
                                if (x + 1 < xMax && x + 1 >= 0 && grid[x + 1][y] == '1') {
                                    queue.add((x + 1) * yMax + y);
                                    grid[x + 1][y] = '0';
                                }
                            }

                            if (x >= 0 && x < xMax) {
                                if (y - 1 >= 0 && y - 1 < yMax && grid[x][y - 1] == '1') {
                                    queue.add(x * yMax + y - 1);
                                    grid[x][y - 1] = '0';
                                }
                                if (y + 1 < yMax && y + 1 >= 0 && grid[x][y + 1] == '1') {
                                    queue.add(x * yMax + y + 1);
                                    grid[x][y + 1] = '0';
                                }
                            }
                        }
                    }
                }
            }
            return res;

        }
    }
}
