/* https://leetcode.com/problems/number-complement/ */

public class Solution {
    public int findComplement(int num) {
        
        int logVal = (int) (Math.log(num) / Math.log(2));
		    int ones = (int) (Math.pow(2, logVal + 1) - 1);
        
    		return num ^ ones;
    }
}
