package offer;
/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @date 2015-7-14
 */
public class Solution11 {
	// 分析，位运算，循环移位
	public int numberOf1(int n) {
		int count = 0;
		for (; n != 0; n >>>= 1) {
			if ((n & 1) == 1) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		int n = -1;
		System.out.println(sol.numberOf1(n));
	}
}