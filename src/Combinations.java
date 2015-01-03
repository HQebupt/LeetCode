import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
	// Solution 1: DFS
	// Time:O(n!) Space:O(n)
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		LinkedList<Integer> intermediate = new LinkedList<Integer>();
		dfs(n, k, 0, 1, intermediate, result);
		return result;
	}

	private void dfs(int n, int k, int step, int start,
			LinkedList<Integer> intermediate, List<List<Integer>> result) {
		// 终止条件
		if (step == k) {
			List<Integer> tmp = new ArrayList<Integer>(intermediate);
			result.add(tmp);
			return;
		}
		for (int i = start; i <= n; i++) {
			intermediate.add(i);
			dfs(n, k, step + 1, i + 1, intermediate, result);
			intermediate.removeLast();
		}
	}

	public static void main(String[] args) {
		Combinations sol = new Combinations();
		System.out.println(sol.combine(4, 2));
	}
}