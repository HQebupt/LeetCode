package offer;
/**
 * 求1+2+3+...+n
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * 思路：发散题，一般的思路是通过一个内部类的静态成员变量，每次生成实例的时候，让`sum += n`。
 * 但是，即使是这样，java语言无法避免不适用for循环来创建对象；而C++可以。
 * @date 2015-8-1下午02:42:17
 */
public class Solution46 {
	static class Temp {
		static int n = 0;
		static int sum = 0;

		public Temp() {
			n++;
			sum += n;
		}
	}
	public int sum_Solution(int n) {
		Temp[] tmps = new Temp[n];
		for(int i = 0; i < n; i++) {// 无法避免不使用for
			tmps[i] = new Temp();
		}
		return Temp.sum;
	}
	public static void main(String[] args) {
		Solution46 sol = new Solution46();
		int n = 5;
		System.out.println(sol.sum_Solution(n));
	}

}
