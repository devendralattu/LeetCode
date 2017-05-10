/*
http://leetcode.com/problems/walls-and-gates/

-1  : A wall or an obstacle.
0   : A gate.
INF : Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Input:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

Output:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

package medium;

public class WallsAndGates {

	private static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int[][] rooms = { { MAX, -1, 0, MAX }, { MAX, MAX, MAX, -1 }, { MAX, -1, MAX, -1 }, { 0, -1, MAX, MAX } };

		int gate = 0;
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					recursiveDFS(rooms, i, j, gate);
				}
			}
		}

		printArray(rooms);
	}

	private static void printArray(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print("|\t" + rooms[i][j] + "\t");
			}
			System.out.println("|");
		}
	}

	private static void recursiveDFS(int[][] rooms, int i, int j, int dist) {

		if (i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1 || rooms[i][j] < dist) {
			return;
		}

		rooms[i][j] = dist++;
		recursiveDFS(rooms, i - 1, j, dist);
		recursiveDFS(rooms, i + 1, j, dist);
		recursiveDFS(rooms, i, j - 1, dist);
		recursiveDFS(rooms, i, j + 1, dist);
	}

}
