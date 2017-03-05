// https://leetcode.com/problems/first-missing-positive

public class Solution {
    public int firstMissingPositive(int[] nums) {
    
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length) {
                if(nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                swap(nums, nums[i] - 1, i);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
            
    }
    
    public static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
