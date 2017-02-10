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
public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 1, res, true);
		return res;
	}

	private void traverse(TreeNode root, int level,
			ArrayList<ArrayList<Integer>> res, Boolean leftToRight) {
		if(root == null) return;
		int size = res.size();
		if(level > size) {
			res.add(new ArrayList<Integer>());
		}
		if(leftToRight){
			res.get(level -1).add(root.val);
		}else{
			res.get(level -1).add(0, root.val);
		}
		traverse(root.left, level + 1 , res, !leftToRight);
		traverse(root.right, level + 1 , res, !leftToRight);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		BinaryTreeZigzagLevelOrderTraversal sol = new BinaryTreeZigzagLevelOrderTraversal();
		ArrayList<ArrayList<Integer>> res = sol.zigzagLevelOrder(t1);
		System.out.println(res);
	}
}