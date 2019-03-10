/*
        Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example:
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
*/

class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int[] palindromeSubstring = new int[] {0, 0};
        int len = s.length();
        for(int i = 0; i < len; i++) {
            updatePalindromeIndex(palindromeSubstring, 
                                  getPalindromeIndex(s, i, i));
            updatePalindromeIndex(palindromeSubstring, 
                                  getPalindromeIndex(s, i, i + 1));
        }

        return s.substring(palindromeSubstring[0], palindromeSubstring[1] + 1);
    }

    private static int[] getPalindromeIndex(String s, int p1, int p2) {
        int left = 0, right = 0;
        int len = s.length();
        while(p1 >= 0 && p2 < len && s.charAt(p1) == s.charAt(p2)) {
            left = p1--;
            right = p2++;
        }
        return new int[] {left, right};
    }

    private static void updatePalindromeIndex(int[] a, int[] b) {
        if(b[1] - b[0] > a[1] - a[0]) {
            System.arraycopy(b, 0, a, 0, 2);
        }
    }
}
