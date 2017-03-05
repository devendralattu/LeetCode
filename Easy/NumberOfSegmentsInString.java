// https://leetcode.com/problems/number-of-segments-in-a-string/

public class Solution {
    public int countSegments(String s) {
        int count = 0;
        if(s == null || s.trim().length() == 0){
            return count;
        }
        
        s = s.trim();
        for(int i = 1 ; i < s.length(); i++){
            if(s.charAt(i) == ' ' && s.charAt(i - 1) != ' '){
                count++;
            }
        }
        count++;
        return count;
    }
}
