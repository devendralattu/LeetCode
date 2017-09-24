/*
        Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example:
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
*/

public String longestPalindrome(String s) {

    if(s == null || s.length() < 2) {
        return s;
    }

    int len = s.length();
    int[] max_start = new int[2];
    // max length and start pointer of the longest palindrome

    for (int i = 0; i < len - 1; i++) {
        expandV (s, i, i, max_start);
        expandV (s, i, i + 1, max_start);
    }

    return s.substring (max_start[1], max_start[1] + max_start[0]);
}

private static void expandV (String s, int j, int k, int[] max_start) {
    int len = s.length();
    while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
        j--;
        k++;
    }

    if(max_start[0] < k - j - 1) {
        max_start[0] = k - j - 1;
        max_start[1] = j + 1;
    }
}
