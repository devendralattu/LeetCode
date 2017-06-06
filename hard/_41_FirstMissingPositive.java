// https://leetcode.com/problems/first-missing-positive

public int firstMissingPositive(int[] nums) {
    if(nums == null) {
        return -1;
    }

    int n = nums.length;
    for(int i = 0; i < n; i++) {
        while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            swap(nums, nums[i] - 1, i);
        }
    }

    int i = -1;
    while(++i < n) {
        if(nums[i] != i + 1) {
            break;
        }
    }
    return i + 1;
}

private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
}
