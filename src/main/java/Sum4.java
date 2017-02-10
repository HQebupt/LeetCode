import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * http://blog.csdn.net/linhuanmars/article/details/24826871
 * http://tech-wonderland.net/blog/summary-of-ksum-problems.html
 * http://www.cnblogs.com/tenosdoit/p/3649607.html
 * http://www.programcreek.com/2013/02/leetcode-4sum-java/
 *
 */
public class Sum4 {
	
	// Solution 1: 
	// Time: O(n^3)  Space: O(n)
	// LinkedList的addLast方法比add方法快。切记切记。
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);

		Set<List<Integer>> set = new HashSet<List<Integer>>();
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int l = j + 1;
				int r = num.length - 1;

				while (l < r) {
					int sum = num[i] + num[j] + num[l] + num[r];

					if (sum < target) {
						l++;
					} else if (sum > target) {
						r--;
					} else if (sum == target) {
						LinkedList<Integer> temp = new LinkedList<Integer>();
						temp.addLast(num[i]);
						temp.addLast(num[j]);
						temp.addLast(num[l]);
						temp.addLast(num[r]);

						if (!set.contains(temp)) {
							set.add(temp);
							result.addLast(temp);
						}
						l++;
						r--;
					}
				}
			}
		}
		return result;
	}
	
	
	// Solution 2:把所有的两两pair都求出来，然后再进行一次Two Sum的匹配
	// Time: O(n^2)  Space: O(n^2)
	class Pair{
		int i1,i2;
		Pair(int i1, int i2) {
			this.i1 = i1;
			this.i2 = i2;
		}
	}
	public List<List<Integer>> fourSum2(int[] num, int target) {
		return null;
	}
	
	
}
