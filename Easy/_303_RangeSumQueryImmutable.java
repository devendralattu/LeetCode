/*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Example:
    Given nums = [-2, 0, 3, -5, 2, -1]
    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3
*/

class NumArray {

    private int[] sum;
    public NumArray(int[] nums) {
        
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        sum = nums;
    }
    
    public int sumRange(int i, int j) {
        return (i == 0) ? sum[j] : sum[j] - sum[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
