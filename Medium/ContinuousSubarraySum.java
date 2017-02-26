// https://leetcode.com/contest/leetcode-weekly-contest-21/problems/continuous-subarray-sum/
// 523. Continuous Subarray Sum
// Time complexity = O(n^2) and space complexity = O(1).
// There is a time O(n) and space O(k) solution for this.

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        for(int i = 1; i < nums.length; i++) {
            int sum = 0;
            for(int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            
            if(k == 0) {
               if(sum == 0) {
                   return true; 
               } return false;
            }
            if(sum % k == 0) {
                return true;
            }
            
            for(int j = i + 1; j < nums.length; j++) {
                sum -= nums[j - i - 1];
                sum += nums[j];
                
                if(k == 0) {
                   if(sum == 0) {
                       return true; 
                   } return false;
                }
                if(sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
