/* https://leetcode.com/problems/plus-one/ */
/*
    Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
    You may assume the integer do not contain any leading zero, except the number 0 itself.
    The digits are stored such that the most significant digit is at the head of the list.
*/

public int[] plusOne(int[] digits) {
    int n = digits.length;

    while(--n >= 0) {
        if(digits[n] < 9) {
            digits[n] += 1;
            return digits;
        }
        digits[n] = 0;
    }

    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
}
