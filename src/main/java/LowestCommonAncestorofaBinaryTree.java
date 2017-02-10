import java.util.Deque;
import java.util.LinkedList;

public class LowestCommonAncestorofaBinaryTree {
	/**
	 * 优雅的代码，手动走一遍就明白了。
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		// If the root is one of a or b, then it is the LCA
		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// If both nodes lie in left or right then their LCA is in left or right,
		// Otherwise root is their LCA
		if (left != null && right != null) {
			return root;
		}

		return (left != null) ? left : right;
	}
	
	/**
	 * Solution 2：找到2个节点p、q的路径，从路径中寻找最低的父节点。
	 * 需要花费额外的存储空间和3次遍历。
	 * Time  Space
	 * 树的时间和空间复杂度怎么计算呢？
	 */
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		Deque<TreeNode> pPath = new LinkedList<TreeNode>();
		Deque<TreeNode> qPath = new LinkedList<TreeNode>();
		findPath(root, p, pPath);
		findPath(root, q, qPath);
		
		TreeNode prev = null;
		for (; !pPath.isEmpty() && !qPath.isEmpty();) {
			TreeNode parent = pPath.removeFirst();
			if (parent == qPath.removeFirst()) {
				prev = parent;
			} else {
				break;
			}
		}
		return prev;
	}
	
	/**
	 * DFS 寻找路径
	 */
	private boolean findPath(TreeNode root, TreeNode node, Deque<TreeNode> path) {
		if (root == null)
			return false;
		if (root == node) {
			path.addLast(root);
			return true;
		}
		path.addLast(root);
		if (findPath(root.left, node, path))
			return true;
		if (findPath(root.right, node, path))
			return true;
		path.removeLast();
		return false;
	}

	public static void main(String[] args) {
		LowestCommonAncestorofaBinaryTree sol = new LowestCommonAncestorofaBinaryTree();
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t0 = new TreeNode(0);
		t6.left = t2;
		t6.right = t8;
		t2.left = t0;
		t2.right = t4;
		t4.left = t3;
		t4.right = t5;
		t8.left = t7;
		t8.right = t9;
		System.out.println(sol.lca(t6, t2, t5));

	}
}
