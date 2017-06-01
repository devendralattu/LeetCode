// https://leetcode.com/problems/two-sum/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        
        int index = 0;
        for(int n : nums) {
            if(map.containsKey(target - n)) {
                int index_0 = map.get(target - n);
                return new int[]{index_0, index};
            }
            map.put(n, index++);
        }
        
        return new int[]{};
    }
}
