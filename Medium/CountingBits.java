/* https://leetcode.com/problems/counting-bits */

public class Solution {
    public int[] countBits(int num) {
        
        int[] result = new int[num + 1];
        int r = -1;
        
        while(++r <= num) {
            result[r] = result[r >> 1] + (r & 01);
        }
        
        return result;
    }
}
