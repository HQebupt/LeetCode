import java.util.LinkedList;

public class WordDictionary {
	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
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

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return dfs(root, word, 0);
	}

	private boolean dfs(TrieNode root, String word, int start) {
		int len = word.length();
		if (start == len) {
			if (root.isEnd)
				return true;
			else
				return false;
		}

		char c = word.charAt(start);
		if (c != '.') {
			TrieNode tmp = root.subNode(c);
			if (tmp == null)
				return false;
			else {
				return dfs(tmp, word, start + 1);
			}
		} else { // '.'
			for (TrieNode next : root.childNode) {
				boolean found = dfs(next, word, start + 1);
				if (found) {
					return true;
				}
			}
		}
		return false;
	}

	static class TrieNode {
		// Initialize your data structure here.
		char content; // 节点内容
		boolean isEnd;// 是否为一个单词的结尾
		LinkedList<TrieNode> childNode;// 该节点所有的孩子节点

		// Initialize your data structure here.
		public TrieNode() {
			this.content = 0;
			this.isEnd = false;
			this.childNode = new LinkedList<TrieNode>();
		}

		public TrieNode(char content) {
			this.content = content;
			this.isEnd = false;
			this.childNode = new LinkedList<TrieNode>();
		}

		public TrieNode subNode(char c) {
			for (TrieNode tn : childNode) {
				if (tn.content == c) {
					return tn;
				}
			}
			return null;
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("add");
		boolean res = wordDictionary.search(".ad");
		System.out.println(res);
	}
}

// Your WordDictionary object will be instantiated and called as such:
