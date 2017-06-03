
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

// Good Reference : https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html

public int majorityElement(int[] nums) {

    if(nums == null || nums.length == 0) return -1;

    int count = 0;
    int candidate = nums[0];

    for(int n : nums){
        if(candidate == n) {
            count++;
        } else if(count == 0) {
            candidate = n;
            count++;
        } else {
            count--;
        }
    }

    // verification stage
    count = 0;
    for(int n : nums) {
        if(n == candidate) {
            count++;
        }
    }

    return (count >= nums.length / 2) ? candidate : -1;
}
