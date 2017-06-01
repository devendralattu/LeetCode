//  581. Shortest Unsorted Continuous Subarray 
// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/#/description
/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.
*/

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int p1 = 0, p2 = 0;
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        
        for(int i = 0; i < n; i++) {
            
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            
            if(nums[i] < max) {
                p1 = i;
            }
            if(nums[n - 1 - i] > min) {
                p2 = n - 1 - i;
            }
        }
        
        return (p1 == 0 && p2 == 0) ? 0 : p1 - p2 + 1;
    }
}
