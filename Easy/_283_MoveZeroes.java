// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 

public void moveZeroes(int[] nums) {

    int prevPos = 0;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] != 0){
            nums[prevPos++] = nums[i];
        }
    }

    fillZeros(nums, prevPos);
}

private void fillZeros(int[] nums, int prevPos){
    for(int i = prevPos; i < nums.length; i++){
        nums[i] = 0;
    }
}
