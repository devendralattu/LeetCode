/* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?tab=Description */

// Negate the values at the occuring number - 1's index 
// loop again to see what all left as postive

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(nums.length / 2);
        
        for(int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        
        return list;
    }
}
