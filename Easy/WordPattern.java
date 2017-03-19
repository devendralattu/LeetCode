// https://leetcode.com/problems/word-pattern/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String[] words = str.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}

		Map<String, Integer> mapWords = new HashMap<>();
		Map<Character, Integer> mapPattern = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);

			if (mapWords.containsKey(words[i]) && mapPattern.containsKey(c)) {
				if (!mapWords.get(words[i]).equals(mapPattern.get(c))) {
					return false;
				}
			} else if (mapWords.containsKey(words[i]) || mapPattern.containsKey(c)) {
				return false;
			}

			mapWords.put(words[i], i);
			mapPattern.put(c, i);
		}

		return true;
    }
}
