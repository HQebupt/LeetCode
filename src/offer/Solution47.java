package offer;
/**
 * 不用加减乘除做加法
 * 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * 思路： 考虑二进制加法的过程，位运算
步骤一、A^B，能够得到没有进位的加法。
步骤二、A&B，能够得到相加之后，能够进位的位置的信息。向左移动一位，就是两个二进制数相加之后的进位信息。
              所以，(A&B)<<1就是两个二进制数相加得到的“进位结果”。
步骤三、将前两步的结果相加。相加的过程就是步骤一和步骤二，直到不再产生进位为止。

Reference：
http://blog.csdn.net/imzoer/article/details/8078712
http://blog.csdn.net/htyurencaotang/article/details/11125415
 * @date 2015-8-1下午03:03:10
 */
public class Solution47 {
	int add(int num1, int num2) {
		int sum = num1 ^ num2, carry = (num1 & num2) << 1;
		for (; carry != 0; sum = num1 ^ num2, carry = (num1 & num2) << 1) {
			num1 = sum;
			num2 = carry;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Solution47 sol = new Solution47();
		int num1 = -2, num2 = 2;
		int res = sol.add(num1, num2);
		System.out.println(res);
	}
}
