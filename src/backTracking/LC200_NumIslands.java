package backTracking;
/*
    题目：岛屿数量
    难度：medium
    给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    此外，你可以假设该网格的四条边均被水包围。
    链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class LC200_NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j, m, n);
        dfs(grid, visited, i - 1, j, m, n);
        dfs(grid, visited, i, j - 1, m, n);
        dfs(grid, visited, i, j + 1, m, n);
    }
}
