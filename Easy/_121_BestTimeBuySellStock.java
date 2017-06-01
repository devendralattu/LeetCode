// https://leetcode.com/problems/best-time-to-buy-and-sell-stock


public int maxProfit(int[] arr) {

    if(arr == null || arr.length < 2) {
        return 0;
    }

    int min = arr[0];
    int profit = 0;

    for(int n : arr) {
        profit = Math.max(profit, n - min);
        min = Math.min(min, n);
    }

    return profit;
}

// If the question involves sell the previous stock at each step

public class Solution {
    public int maxProfit(int[] prices) {
        
        // logic is to keep adding the non-negative differences at each consequtive step (element of array)
        //eg: 1, 3, 5, 6, 10 => answer : 10 - 1 = 9
        //diff = 2  2  1  4  => 2 + 2 + 1 + 4 = 9
        // max_end= 4  5  9  => 9
        
        //eg: 1, 3, 5, 2, 10 => answer : 10 - 1 = 9
        //diff = 2  2  -3  8 => 2 + 2 + -3 + 8 = 9
        // max_end= 4  1  9  => 9
        
        //eg: 1, 3, 5, 0, 10 => answer : 10 - 0 = 10
        //diff = 2  2 -5  10 => 2 + 2 + -3 + 8 = 9
        // max_end= 4 -1  10 => 10
        // set to =    0  
        
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int max_ending_here = 0;
        int max_so_far = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            max_ending_here += prices[i + 1] - prices[i];
            max_ending_here = Math.max(max_ending_here, 0);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        
        return max_so_far;
    }
}
