/*
    For example, given the array [2,3,-2,4],
    the contiguous subarray [2,3] has the largest product = 6. 
*/

public int maxProduct(int[] nums) {

    if(nums == null || nums.length == 0) {
        return -1;
    }

    int result = nums[0], min = 1, max = 1;

    for(int n : nums) {

        // swap two numbers
        if(n < 0) {
            min = min ^ max;
            max = min ^ max;
            min = min ^ max;
        }

        max = Math.max(n, n * max);
        min = Math.min(n, n * min);

        result = Math.max(result, max);
    }

    return result;
}
