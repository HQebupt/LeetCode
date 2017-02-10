package offer;
/**
 * 树的子结构
 * 
 * 题目描述: 输入两颗二叉树A，B，判断B是不是A的子结构
 * @author HuangQiang
 * @date 2015-7-26下午09:30:26
 * @file Solution17.java
 */
public class Solution17 {
	/**
	 * 要查找树A中是否存在和树B结构一样的子树，可以分成两步：
	 * 
	 * 第一步在树A中找到和B的根节点的值一样的结点R；
	 * 
	 * 第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构。
	 * 
	 * 因此，借助一个辅助函数helpSubtree(root1, root2)来做第二步。
	 * 
	 * 需要遍历完所有的root1的节点，才能够判断是否包含子树root2.
	 * 
	 * Time：O(n) Space:O(1)
	 */
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		boolean isSub = false;
		if ((root1 != null) && (root2 != null)) {
			if (root1.val == root2.val) {
				isSub = helpSubtree(root1, root2);
			}
			if (!isSub) {
				isSub = hasSubtree(root1.left, root2);
			}
			if (!isSub) {
				isSub = hasSubtree(root1.right, root2);
			}
		}
		return isSub;
	}

	private boolean helpSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return helpSubtree(root1.left, root2.left)
				&& helpSubtree(root1.right, root2.right);
	}
	
	public static void main(String[] args) {
		Solution17 sol = new Solution17();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		TreeNode tt1 = new TreeNode(1);
		TreeNode tt2 = new TreeNode(2);
		tt1.left = tt2;
		System.out.println(sol.hasSubtree(t1, tt1));
	}
}
