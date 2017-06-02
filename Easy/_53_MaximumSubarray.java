/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
*/

public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0){
        return Integer.MIN_VALUE;
    }
    int max_ending_here = nums[0];
    int max_so_far = max_ending_here;

    for(int i = 1; i < nums.length; i++) {
        max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
        max_so_far = Math.max(max_so_far, max_ending_here);
    }

    return max_so_far;
}
