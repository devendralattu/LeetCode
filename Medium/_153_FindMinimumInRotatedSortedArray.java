/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    Find the minimum element.
    You may assume no duplicate exists in the array
*/

public int findMin(int[] nums) {

    if(nums == null || nums.length == 0) {
        return -1;
    }

    int low = 0;
    int high = nums.length - 1;

    while(high - low > 1) {

        int mid = low + (high - low) / 2;

        if(mid > 0 && nums[mid] < nums[mid-1]) {
            return nums[mid];
        }

        if(nums[mid] > nums[low] && nums[mid] > nums[high]) {
            low = mid;
        } else {
            high = mid;
        }
    }

    return Math.min(nums[high], nums[low]);
}
