public class Trie {
	// 字典树的实现，效率高于HashMap
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		if (search(word)) {
			return;
		}
		int len = word.length();
		TrieNode cur = root;
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			TrieNode tmp = cur.subNode(c);
			if (tmp == null) {
				tmp = new TrieNode(c);
				cur.childNode.add(tmp);
				cur = tmp;
			} else {
				cur = tmp;
			}
		}
		cur.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		int len = word.length();
		TrieNode cur = root;
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			TrieNode tmp = cur.subNode(c);
			if (tmp == null) {
				return false;
			} else {
				cur = tmp;
			}
		}
		return cur.isEnd;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		int len = prefix.length();
		TrieNode cur = root;
		for (int i = 0; i < len; i++) {
			char c = prefix.charAt(i);
			TrieNode tmp = cur.subNode(c);
			if (tmp == null) {
				return false;
			} else {
				cur = tmp;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("somestring");
		trie.insert("key");
		boolean res = trie.startsWith("ke");
		System.out.println(res);
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

