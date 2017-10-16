/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4. 
*/

package medium;

public class _221_MaximalSquare {

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int row = matrix.length;
		int col = matrix[0].length;
		int max = 0;

		// using O(row * col) space
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '0') {
					continue;
				}
				dp[i + 1][j + 1] = min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1;
				max = Math.max(max, dp[i + 1][j + 1]);
			}
		}
		return max * max;
	}

	private static int min(int i, int j, int k) {
		return (i < j) ? ((i < k) ? i : k) : ((j < k) ? j : k);
	}

	public static void main(String[] args) {

		_221_MaximalSquare ms = new _221_MaximalSquare();
		char[][] matrix = new char[][] { { '1', '1', '1', '1' }, { '1', '1', '1', '0' }, { '1', '1', '1', '1' },
				{ '0', '0', '1', '1' } };
		int max_area = ms.maximalSquare(matrix);
		System.out.println("max_area = " + max_area);
	}

}

/*
Optimization using O(col) space:
int prev = 0;
int[] dp = new int[col + 1];
for (int i = 0; i < row; i++) {
  for (int j = 0; j < col; j++) {
    if (matrix[i][j] == '0') {
      prev = dp[j + 1];
      dp[j + 1] = 0;
      continue;
    }
    int temp = dp[j + 1];
    dp[j + 1] = min(prev, dp[j], dp[j + 1]) + 1;
    max = Math.max(max, dp[j + 1]);
    prev = temp;
  }
}
*/
