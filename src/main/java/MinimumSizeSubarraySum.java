public class MinimumSizeSubarraySum {
	/**
	 * Time:O(n^2) Space:O(1) 有更好的解法，时间复杂度：O(nlogn)
	 */
	public int minSubArrayLen(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int count = 0, sum = 0;
			for (int j = i; j < len; j++) {
				sum += nums[j];
				count++;
				if (sum >= s) {
					min = Math.min(min, count);
					break;
				}
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	/**
	 * 时间复杂度：O(nlogn)
	 */
	public int minSubArrayLen1(int s, int[] nums) {
		int len = nums.length;
		int[] sums = new int[len + 1];
		int min = len + 1;
		for (int i = 1; i < len + 1; i++)
			sums[i] = sums[i - 1] + nums[i - 1];
		for (int i = 0; i < len + 1; i++) {
			int right = searchRight(i + 1, len, sums[i] + s, sums);
			System.out.println("right:" + right);
			if (right == len + 1)
				break;
			if (min > right - i)
				min = right - i;
		}
		return min == len + 1 ? 0 : min;
	}

	/*
	 * 用二分查找法找到子数组的右边界位置，使该子数组之和大于sums[i] + s
	 */
	int searchRight(int left, int right, int key, int sums[]) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (sums[mid] >= key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum sol = new MinimumSizeSubarraySum();
		int s = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int res = sol.minSubArrayLen1(s, nums);
		System.out.println(res);
	}
}