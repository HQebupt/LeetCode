package offer;
/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * @date 2015-7-14
 */
public class Solution10 {
	/**
	 * 分析： 递归 公式：F(n) = F(n - 1) + F(n - 2),n>=2; F(1) = 1, F(0) = 0;
	 * sol1：递归超时，复杂度过高
	 * sol2：迭代
	 * sol3：数学公式
	 */
	// Time: O(n) Space: O(1)
	public int fibonacci(int n) {
		if (n < 2)
			return n;
		int prev = 0, curr = 1;
		for (int i = 1; i < n; i++) {
			int tmp = curr;
			curr += prev;
			prev = tmp;
		}
		return curr;
	}
	
	public int fibonacci1(int n) {
		final double s = Math.sqrt(5);
		return (int) ((Math.pow((1 + s) / 2, n ) - Math.pow((1 - s) / 2, n )) * (1.0 / s));
	}
	
	public static void main(String[] args) {
		Solution10 sol = new Solution10();
		int n = 2;
		System.out.println(sol.fibonacci(n));
		System.out.println(sol.fibonacci1(n));
	}
}
