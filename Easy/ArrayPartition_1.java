//  561. Array Partition I 
// https://leetcode.com/problems/array-partition-i/#/description

public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int i = -2, result = 0;
    while((i = i + 2) < nums.length) 
        result = result + nums[i];
    return result;
}
