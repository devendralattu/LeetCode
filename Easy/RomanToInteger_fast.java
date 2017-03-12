// https://leetcode.com/problems/roman-to-integer/

public class Solution {
    
    public int romanToInt(String s) {
        int idx = 0;
        int len = s.length();
        int[] val = new int[len];
        for(char c : s.toCharArray()) {
            switch (c) {
                case 'I' :
                    val[idx++] += 1;
                    break;
                case 'V' :
                    val[idx++] += 5;
                    break;
                case 'X' :
                    val[idx++] += 10;
                    break;
                case 'L' :
                    val[idx++] += 50;
                    break;
                case 'C' :
                    val[idx++] += 100;
                    break;
                case 'D' :
                    val[idx++] += 500;
                    break;
                case 'M' :
                    val[idx++] += 1000;
                    break;
            }
        }
        
        int result = 0;
        idx = 0;
        while(idx < len - 1) {
            if(val[idx] >= val[idx + 1]) {
                result += val[idx++];
            } else {
                result -= val[idx++];
            }
        }
        return result + val[idx];
    }
}
