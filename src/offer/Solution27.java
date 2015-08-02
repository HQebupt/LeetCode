package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树与双向链表
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向.
 * 
 * 思路：中序遍历 + 分治法 1.处理左子树 2.处理当前节点 3.处理右子树
 * 
 * Time：O(n) Space:O(n)
 * 
 * 扩展：能否用非递归来做。
 * Reference：http://blog.csdn.net/zhaojinjia/article/details/9319815
 * 
 * @date 2015-8-2下午02:07:27
 */
public class Solution27 {
	// Sol1: 中序遍历
	public TreeNode convert(TreeNode root) {
		TreeNode pLast = convertNode(root, null);
		for (; (pLast != null) && (pLast.left != null); pLast = pLast.left) {
		}
		return pLast;
	}

	private TreeNode convertNode(TreeNode root, TreeNode pLastListNode) {
		if (root == null)
			return null;
		TreeNode pCur = root;
		// 处理左子树
		if (pCur.left != null) {
			pLastListNode = convertNode(pCur.left, pLastListNode);
		}

		// 处理当前节点
		pCur.left = pLastListNode;
		if (pLastListNode != null) {
			pLastListNode.right = pCur;
		}
		pLastListNode = pCur;

		// 处理右子树
		if (pCur.right != null) {
			pLastListNode = convertNode(pCur.right, pLastListNode);
		}
		return pLastListNode;
	}

	// Solution2: 利用ArrayList来存储
	/**
	 * 思路：ArrayList存储中序遍历的所有节点，然后把所有的节点连接起来成双向链表。
	 * 缺点：多用了O(n)的额外空间，遍历所有节点3次，O(3*n)。
	 * 优点：思路简单，额外的空间和时间数量级上和Solution1，没有区别。
	 * 但是：这条过不了测试用例，虽然我自己检查是对的。
	 */
	public TreeNode convert2(TreeNode root) {
		if (root == null)
			return null;
		List<TreeNode> list = new ArrayList<TreeNode>();
		inOrder(root, list);
		int size = list.size();
		for (int i = 0; i < size - 1; i++) {
			list.get(i).right = list.get(i + 1);
		}
		for (int i = size - 1; i > 1; i--) {
			list.get(i).left = list.get(i - 1);
		}
		return list.get(0);
	}

	private void inOrder(TreeNode root, List<TreeNode> list) {
		if (root != null) {
			inOrder(root.left, list);
			list.add(root);
			inOrder(root.right, list);
		}
	}

	public static void main(String[] args) {
		Solution27 sol = new Solution27();
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		t5.left = t4;
		t4.left = t3;
		t3.left = t2;
		t2.left = t1;
		TreeNode head = sol.convert(t5);
		head = head.right.right.right.right;
		System.out.println(head.leftString());
		
	}
}
