class TrieNode {

	private TrieNode[] letters;
	private boolean leaf;

	public TrieNode() {
		letters = new TrieNode[26];
	}

	public boolean hasLetter(char c) {
		return letters[c - 'a'] != null;
	}

	public void put(char c, TrieNode node) {
		letters[c - 'a'] = node;
	}

	public TrieNode get(char c) {
		return letters[c - 'a'];
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void makeLeaf() {
		leaf = true;
	}
}

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;

		for (char c : word.toCharArray()) {
			if (!node.hasLetter(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}

		node.makeLeaf();
	}

	private TrieNode searchWord(String word) {
		TrieNode node = root;

		for (char c : word.toCharArray()) {
			if (node.hasLetter(c)) {
				node = node.get(c);
			} else {
				return null;
			}
		}

		return node;
	}

	public boolean search(String word) {
		TrieNode node = searchWord(word);
		return node != null && node.isLeaf();
	}

	public boolean startsWith(String word) {
		TrieNode node = searchWord(word);
		return node != null;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("d");

		trie.insert("ant");
		trie.insert("anticipate");
		trie.insert("anticipated");
		trie.insert("and");
		trie.insert("android");
		trie.insert("answer");
		trie.insert("artist");
		trie.insert("bat");
		trie.insert("ball");
		trie.insert("cat");
		trie.insert("call");
		trie.insert("cell");

		System.out.println(trie.search("anticipate"));
		System.out.println(trie.search("bal"));
		System.out.println(trie.search("bell"));

		System.out.println(trie.startsWith("ca"));
		System.out.println(trie.startsWith("be"));
	}
}
