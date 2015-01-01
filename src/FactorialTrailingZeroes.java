// insteresting Question: how can I not pass only 2 test in 502 tests ? No, I was wrong. Because the i*5 can be overflow for int type.
// reference: http://www.purplemath.com/modules/factzero.htm

// Time:O(logn) Space:O(1)
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {

		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5)
			count += n / i;
		return count;
	}

	// there is a better solution : not use long type.
	public int trailingZeroes2(int n) {
		int res = 0;
		for (; n > 4; n /= 5) {
			res += n / 5;
		}
		return res;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes sol = new FactorialTrailingZeroes();
		int res = sol.trailingZeroes(2147483647);
		System.out.println(res);
	}
}
/*
 * To avoid the integer overflow as @localvar mentioned below(in case of 'n
 * >=1808548329' ), the expression " i <= INTMAX/5" is not a good way to prevent
 * overflow, because 5^13 is > INTMAX/5 and it's valid. So, if you want to use
 * "multiply", consider define the 'i' as 'long long' type.
 */
