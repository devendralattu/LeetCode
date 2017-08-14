/*
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police
i.e. you should not rob from adjacent houses
*/

public int rob(int[] nums) {
    int a = 0, b = 0;

    for(int i = 0; i < nums.length; i++) {
        if(i % 2 == 0) {
            a = Math.max(a + nums[i], b);
        } else {
            b = Math.max(b + nums[i], a);
        }
    }

    return Math.max(a, b);
}
