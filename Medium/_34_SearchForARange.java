/*
    Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4]. 
*/

import java.util.Arrays;

public class _34_SearchForARange {

	public static void main(String[] args) {
		_34_SearchForARange s = new _34_SearchForARange();

		int[] result = s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
		System.out.println(Arrays.toString(result));
	}

	public int[] searchRange(int[] nums, int target) {

		int[] range = { -1, -1 };

		if (nums == null || nums.length == 0) {
			return range;
		}

		int i = 0, j = nums.length - 1;

		while (i < j) {
			int mid = (j - i) / 2 + i;

			if (nums[mid] < target)
				i = mid + 1;
			else
				j = mid;
		}

		// no left index found which means there won't be a right index
		if (nums[i] != target) {
			return range;
		}

		range[0] = i;
		j = nums.length - 1;

		while (i < j) {
			int mid = (j - i) / 2 + i + 1; // making pointer biased to the right

			if (nums[mid] > target)
				j = mid - 1;
			else
				i = mid;
		}

		range[1] = j;
		return range;
	}
}
