/**
 * 斐波那契序列
 */
public class ClimbingStairs {
	// Sol 1: 递归 ,超时
	// 递归 公式：F(n) = F(n - 1) + F(n - 2),n>=2; F(1) = 1, F(0) = 0;
	// Time: O(1.618 ^ n) Space: O(n) 空间复杂度取决于递归的深度
	public int climbStairs1(int n) {
		if (n < 2)
			return 1;
		else
			return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	// Sol 2: 迭代
	// Time: O(n) Space: O(1)
	// 186 ms
	public int climbStairs(int n) {
		int prev = 0, curr = 1;
		for (int i = 0; i < n; i++) {
			int tmp = curr;
			curr += prev;
			prev = tmp;
		}
		return curr;
	}

	// Sol 3: 数学公式, 见笔记
	// Time: O(n) Space: O(1)
	// 198 ms
	public int climbStairs3(int n) {
		final double s = Math.sqrt(5);
		return (int) ((Math.pow((1 + s) / 2, n + 1) - Math.pow((1 - s) / 2, n + 1)) * (1.0 / s));
	}
}
