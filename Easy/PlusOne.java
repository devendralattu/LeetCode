/* https://leetcode.com/problems/plus-one/ */
public class Solution {
    public int[] plusOne(int[] digits) {
        
        int one = 1;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--, one = 0) {
            int sum = digits[i] + one + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        
        if(carry > 0){
            int result[] = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits,0,result,1,digits.length);
            return result;
        }
        return digits;
    }
}
