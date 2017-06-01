// https://leetcode.com/problems/third-maximum-number/
/* 
    Given a non-empty array of integers, return the third maximum number in this array. 
    If it does not exist, return the maximum number. 
*/
public class Solution {
    public int thirdMax(int[] nums) {
        
        if(null == nums || nums.length == 0) {
            return -1;
        }
        
        Integer max1 = null, max2 = null, max3 = null;
        
        for(int n : nums) {
            if(max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
                
            } else if(max2 == null || n > max2) {
                if(n == max1) {
                    continue;
                }
                max3 = max2;
                max2 = n;
            } else if(max3 == null || n > max3) {
                if(n == max2) {
                    continue;
                }
                max3 = n;
            }
        }
        
        return (max3 == null) ? max1 : max3;
    }
}
