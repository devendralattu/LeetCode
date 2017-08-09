/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.
{ -4, -3, -2, -1, 60 } = 720  (-4 * -3 * 60)
*/


public int maximumProduct(int[] nums) {

    int[] maxArr = {-1001, -1001, -1001}, minArr = {1001, 1001};

    //find top three min and top three max numbers

    for(int n : nums) {
        if(n >= maxArr[0]) {
            maxArr[2] = maxArr[1];
            maxArr[1] = maxArr[0];
            maxArr[0] = n;
        } else if(n >= maxArr[1]) {
            maxArr[2] = maxArr[1];
            maxArr[1] = n;
        } else if(n >= maxArr[2]) {
            maxArr[2] = n;
        }

        if(n <= minArr[0]) {
            minArr[1] = minArr[0];
            minArr[0] = n;
        } else if(n <= minArr[1]) {
            minArr[1] = n;
        }
    }

    return Math.max(maxArr[0] * maxArr[1] * maxArr[2], maxArr[0] * minArr[1] * minArr[0]);
}
