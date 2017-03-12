// https://leetcode.com/problems/roman-to-integer/

public class Solution {
    
    private static final Map<Character, Integer> MAP = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
    }};
    public int romanToInt(String s) {
        Map<String, Integer> negateMap = new HashMap<>();
        negateMap.put("IV", -2);
        negateMap.put("IX", -2);
        negateMap.put("XL", -20);
        negateMap.put("XC", -20);
        negateMap.put("CD", -200);
        negateMap.put("CM", -200);
        
        int result = 0;
        // substract all negateMap characters 
        for(Map.Entry<String, Integer> entry : negateMap.entrySet()) {
            if(s.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        // add all MAP characters
        for(char c : s.toCharArray()) {
            if(MAP.containsKey(c)) {
                result += MAP.get(c);
            }
        }
        
        return result;
    }
}
