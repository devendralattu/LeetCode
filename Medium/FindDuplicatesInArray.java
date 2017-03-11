// https://leetcode.com/problems/find-all-duplicates-in-an-array 

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     
        List<Integer> list = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                list.add(Math.abs(index + 1));
            }
            nums[index] *= -1; 
        }
        
        return list;
    }
}
