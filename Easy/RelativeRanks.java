/** https://leetcode.com/problems/relative-ranks/ **/

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        
        String[] result = new String[nums.length];
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        int index = 0;
        for(int n : nums){
            map.put(n, index++);
        }
        
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i >= nums.length - 3; i--) {
            
            if(i < 0){
                break;
            }
            int pos = map.get(nums[i]);

            if(i == nums.length - 1){
                result[pos] = "Gold Medal";
            } else if(i == nums.length - 2){
                result[pos] = "Silver Medal";
            } else if(i == nums.length - 3){
                result[pos] = "Bronze Medal";
            }
        }
        
        for(int i = nums.length - 4; i >= 0; i--){
            int pos = map.get(nums[i]);

            result[pos] = Integer.toString(nums.length - i);
        }
        
        return result;
    }
}
