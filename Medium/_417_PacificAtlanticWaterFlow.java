// Note: This is my naive approach which checks for every co-ordinate in the martix.
// Better solution using DFS and BFS on leetcode and notebook.

/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

	Given the following 5x5 matrix:
      Pacific ~   ~   ~   ~   ~ 
           ~  1   2   2   3  (5) *
           ~  3   2   3  (4) (4) *
           ~  2   4  (5)  3   1  *
           ~ (6) (7)  1   4   5  *
           ~ (5)  1   1   2   4  *
              *   *   *   *   * Atlantic
    Return: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		PacificAtlanticWaterFlow pa = new PacificAtlanticWaterFlow();
		int[][] matrix = new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<int[]> list = pa.pacificAtlantic(matrix);
		for (int[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> list = new ArrayList<>();
		if (matrix == null)
			return list;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				dfs(matrix, list, i, j);
			}
		}

		return list;
	}

	private void dfs(int[][] matrix, List<int[]> list, int i, int j) {
		boolean[][] visited;

		visited = new boolean[matrix.length][matrix[0].length];
		boolean pacific = helper(matrix, i, j, visited, true);

		visited = new boolean[matrix.length][matrix[0].length];
		boolean atlantic = helper(matrix, i, j, visited, false);

		if (pacific && atlantic) {
			list.add(new int[] { i, j });
		}
	}

	private boolean helper(int[][] matrix, int i, int j, boolean[][] visited, boolean ocean) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
			return false;
		}

		// only pacific will enter
		if (ocean && (i == 0 || j == 0)) {
			return true;
		}

		// only atlantic will enter
		if (!ocean && (i == matrix.length - 1 || j == matrix[i].length - 1)) {
			return true;
		}

		visited[i][j] = true;
		boolean left = false, right = false, top = false, bottom = false;

		// go left
		if ((j > 0) && !visited[i][j - 1] && (matrix[i][j] >= matrix[i][j - 1])) {
			left = helper(matrix, i, j - 1, visited, ocean);
		}

		// go top
		if ((i > 0) && !visited[i - 1][j] && (matrix[i][j] >= matrix[i - 1][j])) {
			top = helper(matrix, i - 1, j, visited, ocean);
		}

		// go right
		if ((j < matrix[i].length - 1) && !visited[i][j + 1] && (matrix[i][j] >= matrix[i][j + 1])) {
			right = helper(matrix, i, j + 1, visited, ocean);
		}

		// go bottom
		if ((i < matrix.length - 1) && !visited[i + 1][j] && (matrix[i][j] >= matrix[i + 1][j])) {
			bottom = helper(matrix, i + 1, j, visited, ocean);
		}

		return left || top || right || bottom;
	}
}
