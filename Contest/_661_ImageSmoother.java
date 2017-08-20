/*
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:

Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0

Note:
    The value in the given matrix is in the range of [0, 255].
    The length and width of the given matrix are in the range of [1, 150].
*/


package contest;

public class _661_ImageSmoother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] M = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		M = imageSmoother(M);
		printMatrix(M);
	}

	private static void printMatrix(int[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j] + "\t");
			}
			System.out.print("\n");
		}

	}

	public static int[][] imageSmoother(int[][] M) {

		if (M == null || M.length == 0 || M[0].length == 0) {
			return M;
		}

		int n = M.length, m = M[0].length;

		if (m == 1 && n == 1) {
			return M;
		}

		int[][] result = new int[n][m];

		if (m == 1 || n == 1) {
			if (m == 1) {
				int sum = M[0][0] + M[1][0];
				result[0][0] = (int) Math.floor(sum * 1.0 / 2);

				sum = M[n - 1][0] + M[n - 2][0];
				result[n - 1][0] = (int) Math.floor(sum * 1.0 / 2);
			}

			for (int i = 1; i < n - 1; i++) {
				int sum = M[i - 1][0] + M[i][0] + M[i + 1][0];
				result[i][0] = (int) Math.floor(sum * 1.0 / 3);
			}

			if (n == 1) {
				int sum = M[0][0] + M[0][1];
				result[0][0] = (int) Math.floor(sum * 1.0 / 2);

				sum = M[0][m - 1] + M[0][m - 2];
				result[0][m - 1] = (int) Math.floor(sum * 1.0 / 2);
			}

			for (int j = 1; j < m - 1; j++) {
				int sum = M[0][j - 1] + M[0][j] + M[0][j + 1];
				result[0][j] = (int) Math.floor(sum * 1.0 / 3);
			}
		} else {
			// four corners
			int sum = M[0][0] + M[0][1] + M[1][0] + M[1][1];
			result[0][0] = (int) Math.floor(sum * 1.0 / 4);

			sum = M[0][m - 1] + M[0][m - 2] + M[1][m - 1] + M[1][m - 2];
			result[0][m - 1] = (int) Math.floor(sum * 1.0 / 4);

			sum = M[n - 1][0] + M[n - 1][1] + M[n - 2][0] + M[n - 2][1];
			result[n - 1][0] = (int) Math.floor(sum * 1.0 / 4);

			sum = M[n - 1][m - 1] + M[n - 1][m - 2] + M[n - 2][m - 1] + M[n - 2][m - 2];
			result[n - 1][m - 1] = (int) Math.floor(sum * 1.0 / 4);

			for (int i = 1; i < n - 1; i++) {
				sum = M[i - 1][0] + M[i][0] + M[i + 1][0] + M[i - 1][1] + M[i][1] + M[i + 1][1];
				result[i][0] = (int) Math.floor(sum * 1.0 / 6);

				sum = M[i - 1][m - 1] + M[i][m - 1] + M[i + 1][m - 1] + M[i - 1][m - 2] + M[i][m - 2] + M[i + 1][m - 2];
				result[i][m - 1] = (int) Math.floor(sum * 1.0 / 6);
			}

			for (int j = 1; j < m - 1; j++) {
				sum = M[0][j - 1] + M[0][j] + M[0][j + 1] + M[1][j - 1] + M[1][j] + M[1][j + 1];
				result[0][j] = (int) Math.floor(sum * 1.0 / 6);

				sum = M[n - 1][j - 1] + M[n - 1][j] + M[n - 1][j + 1] + M[n - 2][j - 1] + M[n - 2][j] + M[n - 2][j + 1];
				result[n - 1][j] = (int) Math.floor(sum * 1.0 / 6);
			}
		}

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				int sum = M[i - 1][j - 1] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j - 1] + M[i][j] + M[i][j + 1]
						+ M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j + 1];
				result[i][j] = (int) Math.floor(sum * 1.0 / 9);
			}
		}

		return result;
	}
}
