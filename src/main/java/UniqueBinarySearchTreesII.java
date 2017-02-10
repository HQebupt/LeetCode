import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	// 把递归放进循环里面的思想——这样就可以抽离根节点和左右子树节点
	// 一定要清楚每个函数返回什么值，即函数的功能是什么。
	// Time:TODO  Space:TODO  (估计超过了O( n^2 ) )
	public List<TreeNode> generateTrees(int n) {
        return helper(1, n); // 从1作为root开始，到n作为root结束
    }
	
	/**
	 * Function: 用LinkedList测试结果时间优于 ArrayList
	 * @param left BST的左边界
	 * @param right BST的右边界
	 * @return 返回left到right的符合条件的BST。
	 * 比如 helper(1,2) 返回2个BST的List（里面有节点1和节点2）; helper(3,3) 返回1个BST的List（里面只有节点3）。
	 */
	private List<TreeNode> helper(int left, int right) {
		List<TreeNode> res = new LinkedList<TreeNode>();
		if (left > right) {
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> lefts = helper(left, i - 1);// 以i作为根节点，左子树由[left,i-1]构成
			List<TreeNode> rights = helper(i + 1, right);// 右子树由[i+1, right]构成
			int lsize = lefts.size();
			int rsize = rights.size();
			for (int j = 0; j < lsize; j++) 
				for (int k = 0; k < rsize; k++) {
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					res.add(root);
				}
		}
		return res;
	}
}
