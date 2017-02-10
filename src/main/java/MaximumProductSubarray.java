// Referrence:
// http://blog.csdn.net/worldwindjp/article/details/39826823
// 
public class MaximumProductSubarray {
	// Sol 1: 暴力解法 Time Limit Exceeded
	// Time:O(n^3) Space:O(1)
	public int maxProduct(int[] A) {
		int max = 0;
		int size = A.length;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				int mul = product(A, i, j);
				max = Math.max(max, mul);
			}
		}
		return max;
	}

	private int product(int[] a, int start, int end) {
		int mul = 1;
		for (int i = start; i <= end; i++)
			mul *= a[i];
		return mul;
	}

	// Sol 2: DP Time Limit Exceeded
	// Time:O(n^2) Space:O(1)
	public int maxProduct2(int[] A) {
		int max = 0;
		int size = A.length;
		int[][] dp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (i == j)
					dp[i][j] = A[i];
				else {
					dp[i][j] = dp[i][j - 1] * A[j];
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

	// Sol 3:子数组乘积最大值的可能性为：累乘的最大值碰到了一个正数；或者，累乘的最小值（负数），碰到了一个负数。
	// 所以每次要保存累乘的最大（正数）和最小值（负数）。同时还有一个选择起点的逻辑
	// Time: O(n) Space: O(1)
	public int maxProduct3(int[] A) {
		int size = A.length;
		if (A == null || size == 0)
			return 0;
		int maxTmp = A[0];
		int minTmp = A[0];
		int maxProduct = A[0];
		for (int i = 1; i < size; i++) {
			int tmp1 = maxTmp * A[i];
			int tmp2 = minTmp * A[i];
			maxTmp = Math.max(Math.max(tmp1, tmp2), A[i]);
			minTmp = Math.min(Math.min(tmp1, tmp2), A[i]);
			maxProduct = Math.max(maxProduct, maxTmp);
		}
		return maxProduct;
	}

}