package hard;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A, B;
		// A = new int[] { 1, 12, 15, 26 };
		// B = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// A= new int[] { 6 };
		// B= new int[] { 2 };

		// A= new int[] { 1, 3 };
		// B= new int[] { 2, 4, 5 };

		// A= new int[] { 1, 2, 4, 5, 9, 11 };
		// B= new int[] { 3, 6, 7, 8, 10, 12, 13, 14 };

		// A= new int[] { 1, 2};
		// B= new int[] { 3, 4, 5, 6, 7 };

		A = new int[] { 2, 3, 5, 6, 9 };
		B = new int[] { 1, 4, 7, 8 };

		double median = findMedianSortedArrays(A, B);
		System.out.println("Median = " + median);
	}

	private static double findMedianSortedArrays(int A[], int B[]) {
		if (A == null && B == null) {
			return -1;
		}
		if (A == null) {
			A = new int[] {};
		}
		if (B == null) {
			return findMedianSortedArrays(new int[] {}, A);
		}

		int m = A.length;
		int n = B.length;

		if (m > n) {
			return findMedianSortedArrays(B, A);
		}

		int maxLeft = 0, minRight = 0;
		int iMin = 0, iMax = m;
		int i = 0, j = 0;
		while (iMin <= iMax) {
			i = (iMin + iMax) / 2;
			j = (m + n + 1) / 2 - i;

			if (i < m && B[j - 1] > A[i]) {
				iMin = i + 1;
			} else if (i > 0 && A[i - 1] > B[j]) {
				iMax = i - 1;
			} else {
				// Get max from left side
				if (i > 0 && j > 0) {
					maxLeft = Math.max(B[j - 1], A[i - 1]);
				} else if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				}
				break;
			}
		}

		// for odd length, we need to return just one element
		if (((m + n) & 1) == 1) {
			return maxLeft;
		}

		if (i < m && j < n) {
			minRight = Math.min(B[j], A[i]);
		} else if (i == m) {
			minRight = B[j];
		} else if (j == n) {
			minRight = A[i];
		}

		return (maxLeft + minRight) / 2.0;
	}

}
