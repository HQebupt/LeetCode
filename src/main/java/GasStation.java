/**
 * Reference http://www.cnblogs.com/TenosDoIt/p/3389924.html
 * http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html
 * http://www.cnblogs.com/TenosDoIt/p/3698246.html
 */
public class GasStation {
	/**
	 * Solution 1: 贪心：由于题目保证解的唯一性，所以可以如下简单的做 .
	 * gap : gas - cost ;
	 * sum : 局部最大值; 
	 * startIndex : 最大值的起始位置  ;
	 * total : 全局求和 ;
	 * Time: O(n) Space:O(n);
	 * 
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		final int n = gas.length;
		final int[] gap = new int[n];
		int sum = 0, startIndex = 0, total = 0;
		for (int i = 0; i < n; i++) {
			gap[i] = gas[i] - cost[i];
			sum += gap[i];
			total += gap[i];
			if (sum < 0) {
				sum = 0;
				startIndex = i + 1;
			}
		}
		return total < 0 ? -1 : startIndex;

	}
	
	

	/**
	 * Solution 2:
	 * 转换成：求循环数组的连续子数组最大和
	 */
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		final int n = gas.length;
		final int[] gap = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			gap[i] = gas[i] - cost[i];
			sum += gap[i];
		}
		if (sum < 0)
			return -1;

		// 寻找循环子数组中的最大连续子数组
		Index in = new Index(0, 0);
		maxSumCycle(gap,in);
		return in.left;

	}

	// 求循环数组的连续子数组最大和
	class Index {
		int left;
		int right;

		Index(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * 
	 * @param num 输入的数组
	 * @param in 储存子数组最大和的left、right位置, java 基本类型不能够引用，只能够用class了。
	 * @return 最大和
	 */
	private int maxSumCycle(int[] num, Index in) {
		int maxSum = Integer.MIN_VALUE, curMaxSum = 0;
		int minSum = Integer.MAX_VALUE, curMinSum = 0;
		int sum = 0;
		int beginMax = 0, beginMin = 0;
		int minLeft = 0, minRight = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			if (curMaxSum >= 0) {
				curMaxSum += num[i];
			} else {
				curMaxSum = num[i];
				beginMax = i;
			}

			if (maxSum < curMaxSum) {
				maxSum = curMaxSum;
				in.left = beginMax;
				in.right = i;
			}
			
			// 求和最小的子数组
			if (curMinSum <= 0) {
				curMinSum += num[i];
			} else {
				curMinSum = num[i];
				beginMin = i;
			}

			if (minSum > curMinSum) {
				minSum = curMinSum;
				minLeft = beginMin;
				minRight = i;
			}
		}
		
		// 看看是否跨过num[n - 1], num [0]
		if (maxSum + minSum >= sum)
			return maxSum;
		else {
			in.left = minRight + 1;
			in.right = minLeft - 1;
			return sum - minSum;
		}
	}

}
