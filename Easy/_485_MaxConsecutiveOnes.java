// https://leetcode.com/problems/max-consecutive-ones/#/description
// Given a binary array, find the maximum number of consecutive 1s in this array.

public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0, maxSoFar = 0;
    for(int n : nums) {
        maxSoFar = (n == 0) ? 0 : maxSoFar + 1;
        count = Math.max(count, maxSoFar);
    }
    return count;
}
