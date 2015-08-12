import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		String s = "";
		dfs2(n, 0, 0, s, result);
		return result;
	}

	// Time:O(n!) Space:O(n)
	private void dfs(int n, int left, int right, String cur, List<String> result) {
		if (left == n && right == n) {
			String ans = cur.toString();
			result.add(ans);
			return;
		}
		if (left > n || right > n)
			return;
		if (left < n)
			dfs(n, left + 1, right, cur + "(", result);
		if (left - right > 0)
			dfs(n, left, right + 1, cur + ")", result);
	}

	// 第二次写dfs
	private void dfs2(int n, int left, int right, String cur,
			List<String> result) {
		// 终止条件
		if (left == n && (right == n)) {
			result.add(cur);
			return;
		}

		// 剪枝
		if (left < right || (left > n) || (right > n)) {
			return;
		}

		// dfs
		if (left < n) {
			dfs2(n, left + 1, right, cur + "(", result);
			// 恢复状态，由于String和int的特殊性，无需额外的代码
		}
		if (right < n && (left > right)) {
			dfs2(n, left, right + 1, cur + ")", result);
			// 恢复状态，由于String和int的特殊性，无需额外的代码
		}
	}

	public static void main(String[] args) {
		GenerateParentheses sol = new GenerateParentheses();
		int n = 1;
		List<String> res = sol.generateParenthesis(n);
		System.out.println(res.size());
		System.out.println(res);
	}
}