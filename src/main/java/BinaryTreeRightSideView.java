import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Deque<TreeNode> dq = new LinkedList<TreeNode>();
		if (root != null) {
			dq.addLast(root);
		}
		int curNum = 0, lastNum = 1;
		while (!dq.isEmpty()) {
			TreeNode tmp = dq.removeFirst();
			lastNum--;
			int rightSide = tmp.val;
			if (tmp.left != null) {
				dq.addLast(tmp.left);
				curNum++;
			}
			if (tmp.right != null) {
				dq.addLast(tmp.right);
				curNum++;
			}
			if (lastNum == 0) {
				res.add(rightSide);
				lastNum = curNum;
				curNum = 0;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.right = t5;
		t3.right = t4;
		BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
		System.out.println(sol.rightSideView(t1));
	}
}