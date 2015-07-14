package offer;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @date 2015-7-13
 */
public class Solution2 {
	// 找规律：f(n) = 2^(n -1)
	// Time:O(n) Space:O(1)
	public int jumpFloorII(int n) {
		int res = 1;
		for(int i = 1; i < n; i++) {
			res *= 2;
		}
		return res;
	}
}
