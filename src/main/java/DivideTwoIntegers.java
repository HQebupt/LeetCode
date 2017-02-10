public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		// 处理负数
		int xor = dividend ^ divisor;
		int signal = xor >= 0 ? 1 : -1;
		// 正常逻辑
		long count = 0;
		long num = Math.abs((long) dividend), div = Math.abs((long) divisor);
		long tmp = div;
		while (num >= tmp) {
			long countTmp = 1;
			while (num >= tmp) {
				tmp = tmp << 1;
				countTmp = countTmp << 1;
			}
			count += countTmp >> 1;
			tmp = tmp >> 1;
			num = num - tmp;
			tmp = div;
		}
		// 处理溢出的特殊用例{-2147483648, -1}
		long res =  count * signal;
		return  res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
	}

	public static void main(String[] args) {
		DivideTwoIntegers sol = new DivideTwoIntegers();
		int num =-2147483648, div = -1;
		System.out.println(sol.divide(num, div));
	}

}