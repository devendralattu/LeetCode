/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    Example 1:

    Input: "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    Example 2:

    Input: "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] prevWays = new int[s.length()];
        Arrays.fill(prevWays, -1);
        return numWays(s, 0, prevWays);
    }
    
    private static int numWays(String s, int k, int[] prevWays) {
        if (k >= s.length()) {
            return 1;
        }
        if (prevWays[k] > -1) {
            return prevWays[k];
        }
        int result = 0;
        if (k + 1 <= s.length() && isValidNumber(s.substring(k, k + 1))) {
            result += numWays(s, k + 1, prevWays);
        }
        if (k + 2 <= s.length() && isValidNumber(s.substring(k, k + 2))) {
            result += numWays(s, k + 2, prevWays);
        }
        prevWays[k] = result;
        return result;
    }
    private static boolean isValidNumber(String s) {
        return s.charAt(0) != '0' && Integer.parseInt(s) > 0 && Integer.parseInt(s) <= 26;
    }
}
