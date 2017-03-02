/* https://leetcode.com/problems/hamming-distance */

public class Solution {
    public int hammingDistance(int x, int y) {
        
        int count = 0;
        int num = x ^ y;
        while(num != 0) {
            count++;
            num = num & (num - 1) ;
        }
        
        return count;
    }
}
