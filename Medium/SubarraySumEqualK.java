// 560. Subarray Sum Equals K 
// https://leetcode.com/problems/subarray-sum-equals-k/#/description
// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

public class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        int count = 0;
        
        if(nums == null || nums.length == 0) {
            return count;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int n : nums) {
            sum += n;
            
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return count;
    }
}
