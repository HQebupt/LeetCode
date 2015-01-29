import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://tech-wonderland.net/blog/summary-of-ksum-problems.html
 * http://blog.csdn.net/linhuanmars/article/details/19711651
 * 
 */
public class Sum3 {

	// naive solution 1:
	// not handle duplicates, not only time inefficient, also incorrect.
	public List<List<Integer>> threeSum1(int[] num) {
		Arrays.sort(num);
		int i, j, k;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (i = 0; i < num.length; i++) {
			for (j = i + 1; j < num.length; j++) {
				for (k = j + 1; k < num.length; k++) {
					if (num[i] + num[j] + num[k] == 0) {
						List<Integer> path = new ArrayList<Integer>(3);
						path.add(num[i]);
						path.add(num[j]);
						path.add(num[k]);
						result.add(path);
					}
				}
			}
		}
		return result;
	}

	
	// Solution 2: sort , convert problem to TwoSum.
	// Time: O(n^2) Space: O(n)
	/**
	 * previous ：记录 a + b + c ==0 的第一个元素 a, 为了去重。 
	 * l : 左指针
	 * r : 右指针
	 */
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		int previous = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (previous == num[i])
				continue;
			int l = i + 1, r = num.length - 1;
			int target = -num[i];
			while (l < r) {
				int sum = num[l] + num[r];
				if (sum == target) {
					List<Integer> path = new ArrayList<Integer>(3);
					path.add(num[i]);
					path.add(num[l]);
					path.add(num[r]);
					result.add(path);

					// handle duplicate element
					l++;
					while (l < r && num[l - 1] == num[l]) {
						l++;
					}
					r--;
					while (l < r && num[r + 1] == num[r]) {
						r--;
					}
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
			}
			previous = num[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Sum3 sol = new Sum3();
		int[] num = { -2, 0, 0, 2, 2 };
		System.out.println(sol.threeSum(num));
	}
}