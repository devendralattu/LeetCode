public class Solution {
    
    public static Map<Integer, Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        return climbStairsDP(n, map);
    }
    public static int climbStairsDP(int n, Map<Integer, Integer> map) {
        if(n < 0) {
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        
        int value1 = 0;
        if(map.containsKey(n-1)) {
            value1 = map.get(n-1);
        } else {
            value1 = climbStairsDP(n-1, map);
            map.put(n-1, value1);
        }
        
        int value2 = 0;
        if(map.containsKey(n-2)) {
            value2 = map.get(n-2);
        } else {
            value2 = climbStairsDP(n-2, map);
            map.put(n-2, value2);
        }
        return  value1 + value2;
    }
}
