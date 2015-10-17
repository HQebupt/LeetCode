import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	// DFS :easy question,but not easy for me.
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		}
		String tmp = "" + root.val;
		if (root.left == null && root.right == null) {
			result.add(tmp);
		}
		dfs(root.left, tmp, result);
		dfs(root.right, tmp, result);
		return result;
	}

	private void dfs(TreeNode root, String tmp, List<String> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			tmp += "->" + root.val;
			result.add(tmp);
			return;
		}
		tmp += "->" + root.val;
		dfs(root.left, tmp, result);
		dfs(root.right, tmp, result);
	}

	public static void main(String[] args) {
		BinaryTreePaths sol = new BinaryTreePaths();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		System.out.println(sol.binaryTreePaths(t5));
	}
}