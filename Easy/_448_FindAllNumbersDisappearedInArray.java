/* 
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/


public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> list = new ArrayList<>();
    if(nums == null || nums.length == 0) {
        return list;
    }
    for(int i = 0; i < nums.length; i++) {
        int idx = Math.abs(nums[i]) - 1;            // negate the number at index
        nums[idx] = Math.min(nums[idx], -nums[idx]); // keep the numbers negative
    }

    for(int i = 0; i < nums.length; i++) {
        if(nums[i] > 0) {
            list.add(i + 1);
        }
    }

    return list;
}
