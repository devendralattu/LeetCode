/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
such that nums[i] = nums[j] and the absolute difference between i and j is at most k. 
*/

public boolean containsNearbyDuplicate(int[] nums, int k) {

    Set<Integer> set = new HashSet<>();

    //1,2,3,4,1,5,6,9,2,3 k = 2
    for(int i = 0; i < nums.length; i++) {
        if(i - k > 0) {
            set.remove(nums[i - k - 1]);
        }

        if(set.contains(nums[i])) {
            return true;
        } else {
            set.add(nums[i]);
        }
    }

    return false;
}
