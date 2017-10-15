/*
	Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

	Example 1:
	Input: 12
	Output: 21

	Example 2:
	Input: 21
	Output: -1
	
	3465321 => 3512346
	3464321 => 3612344

*/

public int nextGreaterElement(int n) {

    char[] nums = String.valueOf(n).toCharArray();
    int len = nums.length;
    int i = len - 1;

    while(i > 0 && nums[i] <= nums[i - 1]) {
        i--;
    }

    if(i == 0) {
        return -1;
    }

    i--;
    int prev = nums[i];
    int j = i + 1;
    while(j < len && prev < nums[j]) {
        j++;
    }

    j--;

    //swap index at i and j
    swap(nums, i, j);

    //reverse numbers from i + 1 
    while(i + 1 < len - 1) {
        swap(nums, i + 1, len - 1);
        i++;
        len--;
    }

    String digit = new String(nums);
    if(isInteger(digit)) {
        return Integer.parseInt(digit);
    }

    return -1;
}

private static void swap(char[] nums, int i, int j) {
    char temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

private static boolean isInteger(String digit) {
    try {
        Integer.parseInt(digit);
        return true;
    } catch(Exception e) {
        return false;
    }
}
