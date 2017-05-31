// 398. Random Pick Index 
// https://leetcode.com/problems/random-pick-index/#/description
// Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array. 

public class Solution {

    private List<Integer> list;
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        list = new ArrayList<>();
    }
    
    public int pick(int target) {
        int idx = 0;
        for(int n : nums) {
            if(n == target) {
                list.add(idx);
            }
            idx++;
        }
        int rand = (int)(Math.random() * list.size());
        return list.get(rand);
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
