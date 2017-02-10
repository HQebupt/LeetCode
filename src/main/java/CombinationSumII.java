import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<Integer> sum = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		dfs(num, target, 0, sum, result);
		return result;
	}

	private void dfs(int[] candidates, int gap, int start, List<Integer> sum,
			List<List<Integer>> result) {
		if (gap == 0) {
			List<Integer> ans = new ArrayList<Integer>(sum);
			result.add(ans);
			return;
		}
		int pre = -1;
		for (int i = start; i < candidates.length; i++) {
			if (pre == candidates[i])
				continue;
			if (gap < candidates[i])
				return;
			pre = candidates[i];
			sum.add(candidates[i]);
			dfs(candidates, gap - candidates[i], i + 1, sum, result);
			sum.remove(sum.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSumII sol = new CombinationSumII();
		int[] num = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> res = sol.combinationSum2(num, target);
		System.out.println(res);
	}
}