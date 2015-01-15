import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	// Solution 1:
	// 前序遍历的第一个元素必然是根节点，在中序遍历中找到根节点位置，计算中序遍历中根节点前的节点个数，即为左子树的节点个数。
	// 在前序遍历中找到相应个数的节点，输入到左子树递归中，剩下的元素输入到右子树递归中。
	// Time:O(n * logn)  Space:O(logn)
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null)
			return null;

		return buildTreeHelp(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode buildTreeHelp(int[] preorder, int pres, int pree,
			int[] inorder, int instart, int inend) {
		 System.out.println("pre:" + pres + " " + pree);
		 System.out.println("in :" + instart + " " + inend + "\n");
		// 剪枝
		if (pres > pree || instart > inend)
			return null;

		int value = preorder[pres];
		TreeNode root = new TreeNode(value);

		int iroot = 0;
		for (int i = instart; i <= inend; i++) {
			if (value == inorder[i]) {
				iroot = i;
				break; // 没有多重的值
			}
		}

		// left & right recursion
		int count = iroot - instart;
		root.left = buildTreeHelp(preorder, pres + 1, pres + count, inorder,
				instart, iroot - 1);
		root.right = buildTreeHelp(preorder, pres + count + 1, pree, inorder,
				iroot + 1, inend);
		return root;
	}

	
	// Solution 2 : 思路一样，但是采用，我们可以先建立一个HashMap，以免后面需要进行线行搜索.
	// 这样每次递归中就只需要常量操作就可以完成对根的确定和左右子树的分割。
	// 算法最终相当于一次树的遍历，每个结点只会被访问一次，所以时间复杂度是O(n)。而空间复杂度是O(n);
	// Time:O(n) Space:O(n + logn)
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null)
			return null;

		Map<Integer, Integer> nodes = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			nodes.put(inorder[i], i);
		}
		
		return buildTreeHelp(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, nodes );
	}

	private TreeNode buildTreeHelp(int[] preorder, int pres, int pree,
			int[] inorder, int instart, int inend, Map<Integer, Integer> nodes) {
		// 剪枝
		if (pres > pree || instart > inend)
			return null;

		int value = preorder[pres];
		TreeNode root = new TreeNode(value);

		int iroot = nodes.get(value);

		// left & right recursion
		int count = iroot - instart;
		root.left = buildTreeHelp(preorder, pres + 1, pres + count, inorder,
				instart, iroot - 1, nodes);
		root.right = buildTreeHelp(preorder, pres + count + 1, pree, inorder,
				iroot + 1, inend, nodes);
		return root;
	}

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal sol = new ConstructBinaryTreefromPreorderandInorderTraversal();
		int[] preorder = { 1, 2, 4, 5, 3, 6, 8, 7 };
		int[] inorder = { 4, 2, 5, 1, 6, 8, 3, 7 };
		TreeNode res = sol.buildTree(preorder, inorder);
		System.out.println(res.rightString());
	}
}