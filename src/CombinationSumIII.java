import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
	/**
	 * 在 1-9的数字中，找出k个，等于n的组合。
	 * DFS：Time N的指数级
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = i + 1;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new LinkedList<Integer>();
		dfs(nums, n, k, 0, cur, res);
		return res;
	}
	/**
	 * Sum4做成了另外一题去了。
	 * 从数组nums中寻找k个不重复的数，求和等于n。
	 */
	public List<List<Integer>> combinationSum4(int k, int n) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new LinkedList<Integer>();
		dfs(nums, n, k, 0, cur, res);
		return res;
	}

	private void dfs(int[] nums, int gap, int k, int start, List<Integer> cur,
			List<List<Integer>> result) {
		if (k < 0 || gap < 0)
			return;
		if (k == 0 && (gap == 0)) {
			List<Integer> tmp = new ArrayList<Integer>(cur);
			result.add(tmp);
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (gap < nums[i])
				return;
			cur.add(nums[i]);
			k--;
			dfs(nums, gap - nums[i], k, i + 1, cur, result);
			k++;
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		CombinationSumIII sol = new CombinationSumIII();
		int k = 2, n = 18;
		System.out.println(sol.combinationSum3(k, n));
	}


}