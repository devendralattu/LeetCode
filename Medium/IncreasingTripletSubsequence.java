/* https://leetcode.com/problems/increasing-triplet-subsequence/#/description */
// Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array. 

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        if(nums == null || nums.length < 3) {
            return false;
        }
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        
        for(int n : nums) {
            if(n1 >= n) {
                n1 = n;
            } else if(n2 >= n) {
                n2 = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
