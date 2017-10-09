/*
	Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
	connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

	Count the number of distinct islands. An island is considered to be the same as another if and only if one island 
	can be translated (and not rotated or reflected) to equal the other.

	Example 1:
	11000
	11000
	00011
	00011

	Given the above grid map, return 1.

	Example 2:
	11011
	10000
	00001
	11011

	Given the above grid map, return 3.

	Notice that:
	11
	1
	and
	 1
	11
	are considered different island shapes, because we do not consider reflection / rotation.

	Note: The length of each dimension in the given grid does not exceed 50. 
*/

import java.util.HashSet;
import java.util.Set;

public class _694_NumberOfDistinctIslands {

	public static void main(String[] args) {

		int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };

		// int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1,
		// 1 }, { 0, 0, 0, 1, 1 } };
		int area = numDistinctIslands(grid);
		System.out.println(area);
	}

	public static int numDistinctIslands(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		Set<String> set = new HashSet<>();

		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, 0, 0);
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}

	private static void dfs(int[][] grid, int i, int j, StringBuilder sb, int a, int b) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
			grid[i][j] = 0;

			int row = grid.length;
			int col = grid[0].length;

			if (i < row - 1 && grid[i + 1][j] == 1) {
				sb.append((a + 1) + "" + b);
				dfs(grid, i + 1, j, sb, a + 1, b);
			}
			if (i >= 1 && grid[i - 1][j] == 1) {
				sb.append((a - 1) + "" + b);
				dfs(grid, i - 1, j, sb, a - 1, b);
			}
			if (j < col - 1 && grid[i][j + 1] == 1) {
				sb.append(a + "" + (b + 1));
				dfs(grid, i, j + 1, sb, a, b + 1);
			}
			if (j >= 1 && grid[i][j - 1] == 1) {
				sb.append(a + "" + (b - 1));
				dfs(grid, i, j - 1, sb, a, b - 1);
			}
		}
	}
}
