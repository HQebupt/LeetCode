//可参考博文：http://www.programcreek.com/2012/12/leetcode-powx-n/
public class PowXn {
	// Solution1: Last executed input: 0.00001, 2147483647
	// 时间复杂度：O(n)
	public double naiveMethod(double x, int n) {
		double res = 1;
		for (int i = 0; i < n; i++) {
			res *= x;
		}
		return res;
	}

	
	// Solution2: implement Math.pow(x, n)
	public double MathPow(double x, int n) {
		return Math.pow(x, n);
	}

	
	// Solution3: Recursive Method. 时间复杂度：O(logn)
	// X^n = X^(n/2) * X^(n/2) * X^(n%2)
	public double powPositve(double x, int n) {
		int half = n / 2;
		int remainder = n % 2;
		if (half == 0 && (remainder == 0))
			return 1;
		if ((half == 0) && remainder == 1)
			return x;
		double xn2 = powPositve(x, half);
		return xn2 * xn2 * powPositve(x, remainder);
	}

	public double pow3(double x, int n) {
		if (n == Integer.MIN_VALUE)
			return 1 / (x * powPositve(x, -n - 1));
		if (n < 0) {
			return 1 / powPositve(x, -n);
		} else {
			return powPositve(x, n);
		}
	}

	
	// Solution4: The most understandable solution I have found so far.
	// 对solution3 的改进:X^n = X^(n/2) * X^(n/2) * X^(n%2)
	public double powBest(double x, int n) {
		if (n == 0)
			return 1;
		double xn2 = pow(x, n / 2);
		if ((n & 1) != 0)// n is odd
			return xn2 * xn2 * x;
		else
			return xn2 * xn2;
	}

	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / (x * powBest(x, -n - 1));
		} else {
			return powBest(x, n);
		}
	}

	
	public static void main(String[] args) {
		double x = 2;
		int n = 1;
		PowXn sol = new PowXn();
		System.out.println("Math.pow:" + Math.pow(x, n));
		System.out.println("My method:" + sol.pow(x, n));

	}
}