/*

    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

        Only one letter can be changed at a time.
        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

    For example, given that 
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]

    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5. 

*/

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Word {
	private String name = "";
	private int pos = -1;

	public Word(String beginWord, int i) {
		name = beginWord;
		pos = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> set = new HashSet<>(wordList);
		Queue<Word> queue = new LinkedList<>();

		int count = 1;
		queue.add(new Word(beginWord, count));

		while (!queue.isEmpty()) {
			Word w = queue.poll();
			set.remove(w.getName());

			char[] name = w.getName().toCharArray();
			int pos = w.getPos();
			count = pos + 1;

			for (int i = 0; i < name.length; i++) {
				name = w.getName().toCharArray();

				for (char c = 'a'; c <= 'z'; c++) {
					name[i] = c;

					String strName = new String(name);

					if (set.contains(strName)) {
						if (strName.equals(endWord)) {
							return count;
						}
						queue.add(new Word(strName, count));
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLadder wd = new WordLadder();
		List<String> wordList = new ArrayList<String>(
				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));

		String beginWord = "hit";
		String endWord = "cog";

		int result = wd.ladderLength(beginWord, endWord, wordList);
		System.out.println("min path from " + beginWord + " to " + endWord + " = " + result);
	}

}
