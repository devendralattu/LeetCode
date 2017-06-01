/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
public int majorityElement(int[] nums) {
    int count = 0;
    int major = 0;

    for(int n : nums){
        if(count == 0){
            major = n;
        }
        if(major == n){
            count++;
        }
        else{
            count--;
        }
    }

    return major;
}
