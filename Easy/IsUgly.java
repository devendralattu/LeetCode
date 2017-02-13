/* https://leetcode.com/problems/ugly-number */

public class Solution {
    public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        
        num = divideNumLoop(num, 5);
        num = divideNumLoop(num, 3);
        num = divideNumLoop(num, 2);
        
        return num == 1;
    }
    
    public static int divideNumLoop(int number, int factor){
        while(number % factor == 0){
            number /= factor;
        }
        return number;
    }
}
