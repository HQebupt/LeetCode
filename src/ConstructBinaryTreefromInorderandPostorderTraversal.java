import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	// 与先序、中序解法一样
	// Time:O(n)  Space:O(n)
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null)
			return null;
		
		Map<Integer, Integer> nodes = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			nodes.put(inorder[i], i);
		}

		return buildTreeHelp(postorder, 0, postorder.length - 1, inorder, 0,
				inorder.length - 1, nodes);
	}

	private TreeNode buildTreeHelp(int[] postorder, int posts, int poste,
			int[] inorder, int instart, int inend, Map<Integer, Integer> nodes) {
		if (posts > poste || instart > inend)
			return null;
		int value = postorder[poste];
		TreeNode root = new TreeNode(value);

		int iroot = nodes.get(value);
		int count = iroot - instart;

		root.left = buildTreeHelp(postorder, posts, posts + count - 1, inorder,
				instart, iroot - 1, nodes);
		root.right = buildTreeHelp(postorder, posts + count, poste - 1,
				inorder, iroot + 1, inend, nodes);
		return root;
	}

	public static void main(String[] args) {
		ConstructBinaryTreefromInorderandPostorderTraversal sol = new ConstructBinaryTreefromInorderandPostorderTraversal();
		int[] inorder = { 4, 2, 5, 1, 6, 8, 3, 7 };
		int[] postorder = { 4, 5, 2, 8, 6, 7, 3, 1 };
		TreeNode res = sol.buildTree(inorder, postorder);
		System.out.println(res.rightString());
	}
}