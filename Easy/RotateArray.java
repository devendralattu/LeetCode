// https://leetcode.com/problems/rotate-array/
/* Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        if(k <= 0 || nums == null || nums.length == 0 || nums.length == k) {
            return;
        }
        
        int len = nums.length;
        k = k % len;
        
        reverseArray(nums, len - k, len - 1);
        reverseArray(nums, 0, len - k - 1);
        reverseArray(nums, 0, len - 1);
    }
    
    public static void reverseArray(int[] arr, int i, int j){
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
