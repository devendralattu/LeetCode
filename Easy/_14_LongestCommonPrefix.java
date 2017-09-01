/*
    Write a function to find the longest common *prefix* string amongst an array of strings. 
    https://leetcode.com/problems/longest-common-prefix/solution/
    
    ["leets", "leetcode", "leet", "leeds"] => "lee"
    ["leets", "leetcode", "leet", "zleeds"] => ""

*/


public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0) {
        return "";
    }

    String prefix = strs[0];

    for(String s : strs) {
        while(s.indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);

            if(prefix.length() == 0) {
                return "";
            }
        }
    }

    return prefix;
}
