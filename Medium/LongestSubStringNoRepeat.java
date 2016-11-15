/** https://leetcode.com/problems/longest-substring-without-repeating-characters/ **/
public class LongestSubStringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        
        int i = 0, j = 0;
        int len = s.length();
        int max = 0;
        Set<Character> set = new HashSet<Character>(len);
        
        while(i < len && j < len){
            
            char val = s.charAt(j);
            
            if(!set.contains(val)){
                set.add(val);
                j++;
                max = Math.max(max, j - i);
            }
            else{
                char remVal = s.charAt(i);
                set.remove(remVal);
                i++;
            }
            
        }
        
        return max;
    }
}
