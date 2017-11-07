/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

class Solution {
    public static char[][] arr = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();

		if (!isInteger(digits)) {
			return list;
		}

		StringBuilder sb = new StringBuilder();
		letterCombinations(digits, 0, sb, list);
		return list;

	}

	public static void letterCombinations(String digits, int idx, StringBuilder sb, List<String> list) {
		if (idx == digits.length()) {
			list.add(sb.toString());
			return;
		}
		int arrIdx = (int) (digits.charAt(idx) - '0');
		for (int i = 0; i < arr[arrIdx].length; i++) {
			sb.append(arr[arrIdx][i]);
			letterCombinations(digits, idx + 1, sb, list);
			sb.setLength(sb.length() - 1);
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
