/*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
    prove that at least one duplicate number must exist. 
    Assume that there is only one duplicate number, find the duplicate one. 
*/

// WITHOUT modifying the array : similar to finding loop in Linked List
public int findDuplicate(int[] nums) {
    if(nums == null || nums.length == 0) return 0;

    int slow = nums[0];
    int fast = nums[nums[0]];

    while(slow != fast) {
        slow = nums[slow];
        fast = nums[nums[fast]];
    }

    fast = 0;
    while(slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }

    return slow;
}

// WITH array modification O(n)
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
