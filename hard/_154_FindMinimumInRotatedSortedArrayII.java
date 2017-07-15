/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 0 1 2 2 4 5 6 7 might become 2 4 5 6 7 0 0 1 2).
Find the minimum element.

*/
public int findMin(int[] nums) {
    if(nums == null || nums.length == 0) {
        return -1;
    }
    int low = 0, high = nums.length - 1;

    while(high > low) {
        int mid = low + (high - low) / 2;

        if(nums[mid] > nums[high]) {
            low = mid + 1;
        } else if(nums[mid] < nums[high]) {
            high = mid;
        }
        else {
            high--;
        }
    }
    return nums[low];
}
