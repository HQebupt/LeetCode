import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> sum = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, sum, result);
		return result;
	}

	private void dfs(int[] candidates, int gap, int start, List<Integer> sum,
			List<List<Integer>> result) {
		if (gap == 0) {
			List<Integer> ans = new ArrayList<Integer>(sum);
			result.add(ans);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (gap < candidates[i])
				return;
			if (gap >= candidates[i]) {
				sum.add(candidates[i]);
				dfs(candidates, gap - candidates[i], i, sum, result);
				sum.remove(sum.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum sol = new CombinationSum();
		int[] candidates = {8,7,4,3};
		int target = 11;
		List<List<Integer>> res = sol.combinationSum(candidates, target);
		System.out.println(res);
	}
}