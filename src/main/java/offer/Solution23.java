package offer;

import java.util.LinkedList;
import java.util.List;
/**
 * 从上往下打印二叉树
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * 思路：本质是层序遍历二叉树，借助于队列保存每一层的TreeNode,不断遍历队列的节点即可得到。
 * @date 2015-7-28下午05:38:50
 */
public class Solution23 {
	public List<Integer> printFromTopToBottom(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> res = new LinkedList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		printHelp(res, queue);
		return res;
	}

	private void printHelp(List<Integer> res, LinkedList<TreeNode> queue) {
		while (!queue.isEmpty()) {
			TreeNode root = queue.getFirst();
			res.add(root.val);
			if (root.left != null)
				queue.addLast(root.left);
			if (root.right != null)
				queue.addLast(root.right);
			queue.removeFirst();
		}
	}

	public static void main(String[] args) {
		Solution23 sol = new Solution23();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t2.right = t3;
		System.out.println(sol.printFromTopToBottom(t1));
	}
}
