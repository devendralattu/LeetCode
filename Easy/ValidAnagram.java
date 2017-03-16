// https://leetcode.com/problems/valid-anagram

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        //You may assume the string contains only lowercase alphabets.
        
        int sLen = s.length();
        int tLen = t.length();
        int[] alphabets = new int[26];
        
        for (int i = 0; i < sLen; i++) { 
            alphabet[s.charAt(i) - 'a']++;
        }    
        for (int i = 0; i < tLen; i++) {
            alphabet[t.charAt(i) - 'a']--;
        }    
        for (int i : alphabet) {
            if (i != 0) { 
                return false;
            }    
        }
        return true;
    }
}
