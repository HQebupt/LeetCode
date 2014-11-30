import java.util.ArrayList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time:O(n) Space:O(n)
public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res);
		return res;
	}
	
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res);
		int size = res.size();
		ArrayList<ArrayList<Integer>> resReverse = new ArrayList<ArrayList<Integer>>();
		for(int i = size - 1; i >= 0; i--) {
			resReverse.add(res.get(i));
		}
		return resReverse;
	}

	private void traverse(TreeNode root, int level,
			ArrayList<ArrayList<Integer>> res) {
		if (root == null)
			return;
		int size = res.size();
		if (level > size) {
			res.add(new ArrayList<Integer>());
		}
		res.get(level - 1).add(root.val);
		traverse(root.left, level + 1, res);
		traverse(root.right, level + 1, res);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
		ArrayList<ArrayList<Integer>> res = sol.levelOrderBottom(t1);
		System.out.println(res);
	}
}