public class LowestCommonAncestorofaBinarySearchTree {
	/**
	 * 根据BST的性质，两个节点p，q的公共袓先root, 一定满足p <= root <= q 或者 p >= root >= q。
	 * 
	 * 使用递归可以轻松解决此问题。分为三种情况讨论：
	 * 1. P, Q都比root小，则LCA在左树，我们继续在左树中寻找LCA
	 * 
	 * 2. P, Q都比root大，则LCA在右树，我们继续在右树中寻找LCA
	 * 
	 * 3. 其它情况，表示P,Q在root两边，或者二者其一是root，或者都是root，这些情况表示root就是LCA，直接返回root即可。
	 */
	// 递归
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;
		final int value = root.val;
		if (Math.max(p.val, q.val) < value)
			return lowestCommonAncestor(root.left, p, q);
		if (Math.min(p.val, q.val) > value)
			return lowestCommonAncestor(root.right, p, q);
		return root;
	}

	// 迭代做法
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode cur = root;
		for (;;) {
			int value = cur.val;
			if (p.val < value && q.val < value)
				cur = cur.left;
			else if (p.val > value && q.val > value)
				cur = cur.right;
			else
				return cur;
		}
	}

	public static void main(String[] args) {
		LowestCommonAncestorofaBinarySearchTree sol = new LowestCommonAncestorofaBinarySearchTree();
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
		System.out.println(sol.lowestCommonAncestor(t6, t2, t8));
		System.out.println(sol.lca(t6, t7, t9));

	}
}
