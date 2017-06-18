/*
    Given m arrays, and each array is sorted in ascending order. 
    Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. 
    We define the distance between two integers a and b to be their absolute difference |a-b|. 
    Your task is to find the maximum distance.

    Example 1:
        Input: 
        [[1,2,3],
         [4,5],
         [1,2,3]]

        Output: 4
        
    Explanation: 
        One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
    Note:
        Each given array will have at least 1 number. There will be at least two non-empty arrays.
        The total number of the integers in all the m arrays will be in the range of [2, 10000].
        The integers in the m arrays will be in the range of [-10000, 10000].
*/

// Find min and max values from the 2-D array.
// Now find the min and max values which are not in the array of earlier min and max.
// Return the max difference between them.
// Remember, we need to return the max diff from two arrays and thus running min max only once 
// might give us elements from same array

public int maxDistance(int[][] arrays) {

		int p1 = -1, p2 = -1;
		int min1, min2, max1, max2;
		min1 = min2 = 10001;
		max1 = max2 = -10001;

		int len1 = arrays.length;

		for (int i = 0; i < len1; i++) {
			int[] arr = arrays[i];
			int len2 = arr.length;

			if (arr[0] < min1) {
				min1 = arr[0];
				p1 = i;
			}

			if (arr[len2 - 1] > max2) {
				max2 = arr[len2 - 1];
				p2 = i;
			}
		}

		for (int i = 0; i < len1; i++) {
			int[] arr = arrays[i];
			int len2 = arr.length;

			if (arr[len2 - 1] > max1 && i != p1) {
				max1 = arr[len2 - 1];
			}

			if (arr[0] < min2 && i != p2) {
				min2 = arr[0];
			}
		}

		return Math.max(Math.abs(max1 - min1), Math.abs(max2 - min2));
}
