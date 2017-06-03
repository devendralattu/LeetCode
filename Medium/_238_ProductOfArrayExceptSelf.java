/** https://leetcode.com/problems/product-of-array-except-self **/

public int[] productExceptSelf(int[] nums) {
    if(nums == null) return new int[]{};

    int[] result = new int[nums.length];
    result[0] = 1;

    for(int i = 1; i < nums.length; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }

    int product = 1;
    for(int i = nums.length - 1; i >= 0; i--) {
        result[i] *= product;
        product *= nums[i];
    }

    return result;
}
