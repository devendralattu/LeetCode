/* https://leetcode.com/problems/single-number-ii */
// Given an array of integers, every element appears three times except for one, 
// which appears exactly once. Find that single one.

public int singleNumber(int[] nums) {
        
        int ans = 0;
        for(int i = 0; i < 32; i++){
            
            //iterating for every bit starting from LSB
            int sum = 0;
            for(int j = 0; j < nums.length; j++){
                
                //check if the 'i'th bit is set
                if(((nums[j] >> i) & 1) == 1){
                    sum++;
                    sum %= 3;
                }
            }
            
            if(sum == 1){
                ans |= (sum << i);
            }
        }
        
        return ans;
    }
