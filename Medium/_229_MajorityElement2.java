// https://leetcode.com/problems/majority-element-ii/#/description
// 229. Majority Element II 
/*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
    The algorithm should run in linear time and in O(1) space.
*/

public List<Integer> majorityElement(int[] nums) {
    List<Integer> list = new ArrayList<>();
    if(null == nums || nums.length == 0) return list;

    int count1 = 0, count2 = 0, candidate1 = nums[0], candidate2 = nums[0];

    for(int n : nums) {
        if(candidate1 == n) {
            count1++;
        } else if(candidate2 == n) {
            count2++;
        } else if(count1 == 0) {
            candidate1 = n;
            count1++;
        } else if(count2 == 0) {
            candidate2 = n;
            count2++;
        } else {
            count1--;
            count2--;
        }
    }

    // verification stage
    count1 = count2 = 0;
    for(int n : nums) {
        if(candidate1 == n) {
            count1++;
        } else if(candidate2 == n) {
            count2++;
        }
    }

    if (count1 > nums.length/3) 
        list.add(candidate1);

    if (count2 > nums.length/3) 
        list.add(candidate2);

    return list;    
}
