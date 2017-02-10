package offer;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @date 2015-7-13
 */
public class Solution1 {

	/**
	 * 斐波那契数列的变种：见 ClimbingStairs-leetcode
	 */
	// Sol1:递归
	// Time: O(1.618 ^ n) Space: O(n) 空间复杂度取决于递归的深度
	public int jumpFloor(int n) {
		if (n < 2)
			return 1;
		return jumpFloor(n - 1) + jumpFloor(n - 2);
	}

	// Sol2: 迭代实现
	// Time: O(n) Space: O(1)
	public int jumpFloor2(int n) {
		int prev = 0, curr = 1;
		for (int i = 0; i < n; i++) {
			int tmp = curr;
			curr += prev;
			prev = tmp;
		}
		return curr;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		int n = 2;
		System.out.println(sol.jumpFloor2(n));
	}
}