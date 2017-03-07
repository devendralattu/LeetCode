// https://leetcode.com/problems/zigzag-conversion/

public class Solution {
    public String convert(String s, int numRows) {
        
        // initial test case
        if(numRows == 1 || s == null || s.length() == 0 || numRows > s.length()) {
            return s;    
        }
        int len = s.length();
        
        // initialize array of string buffers
        StringBuilder sb[] = new StringBuilder[numRows];
        
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        // Fill in each level of StringBuilder array
        int i = 0;
        while(i < len) {
            
            int sb_index = 0;
            while(sb_index < numRows && i < len) {
                char c = s.charAt(i++);
                sb[sb_index++].append(c);
            }
            
            // fill from bottom to top (for zig-zag)
            sb_index = numRows - 2;
            while(sb_index > 0 && i < len) {
                char c = s.charAt(i++);
                sb[sb_index--].append(c);
            }
        }
        
        
        // append rest of string builder values to first string builder
        i = 1;
        while(i < numRows) {
            sb[0].append(sb[i++]);
        }
        
        return sb[0].toString();
    }
}
