/* 
  https://leetcode.com/problems/number-of-islands/
  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

  Example 1:

  Input:
  11110
  11010
  11000
  00000

  Output: 1
  
  Example 2:

  Input:
  11000
  11000
  00100
  00011

  Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 
            visited[i][j] || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
}
