package com.dpf.dfs;

/**
 * 岛屿数量
 * @author Pikachues
 * Created 2022/1/17
 */
public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int res = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]=='1'&&!visited[i][j]){
                        dfs(grid,i,j,visited);
                        res++;
                    }
                }
            }
            return res;
        }
        public void dfs(char[][] grid,int x,int y,boolean[][] visited){
            int xMax = grid.length;
            int yMax = grid[0].length;
            if(x>=xMax||x<0||y<0||y>=yMax||grid[x][y]=='0'){
                return;
            }

            if(!visited[x][y]&&grid[x][y]=='1'){
                visited[x][y]=true;
                dfs(grid,x+1,y,visited);
                dfs(grid,x-1,y,visited);
                dfs(grid,x,y+1,visited);
                dfs(grid,x,y-1,visited);
            }
        }
    }
}
