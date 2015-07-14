package offer;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * @date 2015-7-13
 */
public class Solution3 {
	// 斐波那契序列
	public int rectCover(int n) {
		int prev = 1, curr = 1;
		for (int i = 1; i < n; i++) {
			int tmp = curr;
			curr += prev;
			prev = tmp;
		}
		return curr;
	}
}
