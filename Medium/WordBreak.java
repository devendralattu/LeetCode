// https://leetcode.com/problems/word-break/

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        
        int len = s.length();
        boolean[] safe = new boolean[len + 1];
        safe[0] = true;
        
        for(int i = 1; i < len + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(safe[j] && wordDict.contains(s.substring(j, i))) {
                    safe[i] = true;
                    break;
                }
            }
        }
        return safe[len];
    }
}
