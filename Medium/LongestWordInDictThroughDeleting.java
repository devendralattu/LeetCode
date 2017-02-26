// https://leetcode.com/contest/leetcode-weekly-contest-21/problems/longest-word-in-dictionary-through-deleting/
// 524. Longest Word in Dictionary through Deleting
// I tried using StringBuilder but to make stuff simpler changed it to String.
// else word.toString(); word.setLength(0); word.trimToSize(); word.append(dict); had nearly same complexity as Strings
// Runtime complexity = O(nk); n is the length of string s and k is the number of words in the dictionary.

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        int len = s.length();
        int max = 0;
        String word = new String("");
        for(String dict : d) {
            int dp = 0, sp = 0;
            int dictLen = dict.length();
            
            while(dp < dictLen && sp < len) {
                if(dict.charAt(dp) == s.charAt(sp)) {
                    dp++;
                }
                sp++;
            }
            
            if(dp == dictLen && dictLen >= max) {
                if(dictLen > max || word.length() == 0 || dict.compareTo(word) < 0) {
                    max = dictLen;
                    word = dict;
                }
            }
        }
        
        return word;
    }
}
