// https://leetcode.com/problems/search-insert-position/

public int searchInsert(int[] nums, int target) {
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int len = nums.length;

    // Just to speed up
    if(target < nums[0]) {
        return 0;
    } else if(target > nums[len - 1]) {
        return len;
    }

    /* actual logic */
    int start = 0, end = len - 1;
    while(start <= end) {
        int middle = start + (end - start) / 2;

        if(target == nums[middle]) {
            return middle;
        }

        if(target < nums[middle]) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
    }
    return start;
}
