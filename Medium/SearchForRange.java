// https://leetcode.com/problems/search-for-a-range/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        int result[] = {-1, -1};
        
        if(nums == null || nums.length == 0){
            return result;    
        }
        
        // Set left pointer
        while (low < high)
        {
            int mid = (low + high) /2;
            if (nums[mid] < target) 
                low = mid + 1;
            else 
                high = mid;
        }
        
        if (nums[low] != target) 
            return result;
        
        result[0] = low;
        
        // Set right pointer
        
        // reset high pointer
        high = nums.length - 1;
        
        while (low < high)
        {
            // Make mid biased to the right
            int mid = (low + high) / 2 + 1;
            
            if (nums[mid] > target) 
                high = mid - 1;  
            else low = mid;
        }
        
        result[1] = high;
        
        return result; 
    }
}
