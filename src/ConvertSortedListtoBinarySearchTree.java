import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
	// Solution 1: Top Down. 转换成 上一题的array求解
	// Time: O(n)  Space: O(n + logn)
    public TreeNode sortedListToBST1(ListNode head) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	int length = 0;
    	for (; head != null; head = head.next) {
    		list.add(head.val);
    		length++;
    	}
    	ArrayList<Integer> array = new ArrayList<Integer>(list);
    	return sortedArrayToBST(array, 0, length - 1);
    }
    
    // 辅助方法
    private TreeNode sortedArrayToBST(List<Integer> num, int start, int end) {
		if (end - start < 0) return null;
		int mid = (end + start) >> 1;
		TreeNode root = new TreeNode(num.get(mid));
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
		return root;
	}
    
    
    // Solution 2 : Down Top 参考BST的中序遍历
    // Time: O(n)  Space: O(logn)
    private static ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
    	cur = head;
    	int length = 0;
    	for (; head != null; head = head.next) {
    		length++;
    	}
    	return sortedListToBST(0, length - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
    	if (end - start < 0) return null;
    	int mid = (start + end) >> 1;
    	TreeNode left = sortedListToBST(start, mid -1);
    	TreeNode parent = new TreeNode(cur.val);
    	parent.left = left;
    	cur = cur.next; // 致命的一点,java无法改变局部变量的地址的值。cur在弹栈后，进栈和出栈。只有利用static变量,达到目的。
    	parent.right = sortedListToBST(mid + 1, end);
    	return parent;
    }
}