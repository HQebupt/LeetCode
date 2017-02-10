import java.util.LinkedList;

public class TrieNode {
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

	@Override
	public String toString() {
		return ("content:" + content + "\n child:" + childNode.toString());
	}
}
