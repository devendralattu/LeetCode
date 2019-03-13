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


/*
class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return list;
        }
        char[] numbers = digits.toCharArray();

        List<List<Character>> dialPad = new ArrayList<>();
        fillDialPad(dialPad);

        numberCombination(numbers, dialPad, list, 0, new StringBuilder());
        return list;
    }

    private static void numberCombination(char[] numbers, List<List<Character>> dialPad, List<String> list,
                                          int i, StringBuilder sb) {
        if (i == numbers.length) {
            list.add(sb.toString());
        } else {
            int num = Character.getNumericValue(numbers[i]);
            for (int pos = 0; pos < dialPad.get(num).size(); pos++) {
                sb.append(dialPad.get(num).get(pos));
                numberCombination(numbers, dialPad, list, i + 1, sb);
                // delete last char
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private static void fillDialPad(List<List<Character>> dialPad) {
        dialPad.add(0, new ArrayList<>(Arrays.asList(' ')));
        dialPad.add(1, new ArrayList<>(Arrays.asList('*')));
        dialPad.add(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        dialPad.add(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        dialPad.add(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        dialPad.add(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        dialPad.add(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        dialPad.add(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        dialPad.add(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        dialPad.add(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }
}
*/
