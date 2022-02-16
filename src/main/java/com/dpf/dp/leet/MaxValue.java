package com.dpf.dp.leet;

/**
 * 礼物的最大值
 * @author Pikachues
 * Created 2022/2/13
 */
public class MaxValue {
    class Solution {
        public int maxValue(int[][] grid) {
            int row = grid.length;
            int column = grid[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
            return grid[row - 1][column - 1];
        }
    }
}
