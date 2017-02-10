import java.util.Deque;
import java.util.LinkedList;

public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode> dq = new LinkedList<TreeNode>();
		if (root == null) {
			return sb.toString();
		}
		sb.append(root.val);
		dq.add(root.left);
		dq.add(root.right);

		while (!dq.isEmpty()) {
			TreeNode p = dq.removeFirst();
			if (p != null) {
				sb.append("," + p.val);
				dq.add(p.left);
				dq.add(p.right);
			} else {
				sb.append(",");
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null | data.length() == 0) {
			return null;
		}

		String[] words = data.split(",", -1);
		Deque<TreeNode> dq = new LinkedList<TreeNode>();
		for (String word : words) {
			if (!word.equalsIgnoreCase("")) {
				TreeNode t = new TreeNode(Integer.parseInt(word));
				dq.add(t);
			} else {
				dq.add(null);
			}
		}

		Deque<TreeNode> tmp = new LinkedList<TreeNode>();
		TreeNode head = dq.removeFirst();
		tmp.add(head);

		while (!tmp.isEmpty()) {
			TreeNode p = tmp.removeFirst();
			TreeNode left = dq.removeFirst();
			TreeNode right = dq.removeFirst();
			if (left != null) {
				tmp.add(left);
			}
			if (right != null) {
				tmp.add(right);
			}
			p.left = left;
			p.right = right;
		}
		return head;

	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		TreeNode res = codec.deserialize(codec.serialize(t1));
		System.out.println(res.rightString());
	}

}
