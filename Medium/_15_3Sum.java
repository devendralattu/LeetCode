/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
The solution set must not contain duplicate triplets.

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);
        
        int i = 0;
        while(i < nums.length - 2) {
            int k = i + 1;
            int j = nums.length - 1;
            
            while(k < j) {
                if(nums[i] + nums[k] + nums[j] < 0) {
                    k++;
                } else if (nums[i] + nums[k] + nums[j] > 0) {
                    j--;
                } else {
                    prepareToAddPairs(nums, i, j, k, pairs);
                    
                    k++; j--;
                    
                    while(k < j && nums[k] == nums[k - 1]) {
                        k++;
                    }
                    while(j > k && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }
            }
            
            i++;
            while(i < nums.length - 1 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        
        return pairs;
    }
    
    private static void prepareToAddPairs(int[] nums, int i, int j, int k,
                                          List<List<Integer>> pairs) {
        pairs.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
    }
}
