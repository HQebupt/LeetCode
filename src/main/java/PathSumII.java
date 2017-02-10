import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		LinkedList<Integer> cur = new LinkedList<Integer>();
		pathSum(root, sum, cur, res);
		return res;
	}

	private void pathSum(TreeNode root, int gap, LinkedList<Integer> cur,
			List<List<Integer>> res) {
		if (root == null)
			return;
		cur.add(root.val);
		if (root.left == null && root.right == null && (gap == root.val)) {
			LinkedList<Integer> tmp = new LinkedList<Integer>(cur);
			res.add(tmp);
		} else {
			pathSum(root.left, gap - root.val, cur, res);
			pathSum(root.right, gap - root.val, cur, res);
		}
		cur.removeLast();
	}

	public static void main(String[] args) {
		PathSumII sol = new PathSumII();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.setLeft(t2);
		t1.setRight(t3);
		t2.setLeft(t4);
		int sum = 4;
		System.out.println(sol.pathSum(t1, sum));
	}
}