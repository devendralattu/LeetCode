/*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
    prove that at least one duplicate number must exist. 
    Assume that there is only one duplicate number, find the duplicate one. 
*/

public int findDuplicate(int[] nums) {
    if(nums == null) return 0;

    for(int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]);
        if(nums[index - 1] < 0) {
            return index;
        }
        nums[index - 1] = -nums[index - 1];
    }
    return 0;
}
