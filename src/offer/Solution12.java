package offer;
/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @date 2015-7-16
 */
public class Solution12 {
	// Solution 1：调用库函数
	public double power(double base, int exponent) {
		return Math.pow(base, exponent);
	}
	
	/**
	 * Solution2：自己实现
	 * @param base 是否为0，如何和0进行比较的问题。个人认为，前提条件应该保证base不为0。
	 * @param exponent 正负数的考虑
	 */
	public double power1(double base, int exponent) {
		if(exponent >= 0) {
			return powerHelp(base,exponent);
		} else {
			return 1.0d / powerHelp(base,-exponent);
		}
		
	}

	private double powerHelp(double base, int exponent) {
		double result = 1.0d;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
}
