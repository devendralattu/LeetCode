// https://leetcode.com/problems/find-all-duplicates-in-an-array 
/*
    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements that appear twice in this array.
*/

public List<Integer> findDuplicates(int[] nums) {

    List<Integer> list = new ArrayList<>();
    if(null == nums) {
        return list;
    }

    for(int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]);
        if(nums[index - 1] < 0) {
            list.add(index);
        }
        nums[index - 1] *= -1; 
    }

    return list;
}
