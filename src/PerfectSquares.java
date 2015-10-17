public class PerfectSquares {

	/**
	 * 四平方和定理，来解这题最快。另外DP可以解，动态规划方程不好找，目前没理解。
	 */
	public int numSquares(int n) {
		while (n % 4 == 0) {
			n = n / 4;
		}
		if (n % 8 == 7) {
			return 4;
		}
		for (int i = 0; i * i <= n; i++) {
			int j = (int) Math.sqrt(n - i * i);
			if (i * i + j * j == n) {
				if ((i != 0) && (j != 0)) {
					return 2;
				} else {
					return 1;
				}
			}
		}
		return 3;
	}

	public static void main(String[] args) {
		PerfectSquares sol = new PerfectSquares();
		int n = 3;
		int c = sol.numSquares(n);
		System.out.println(c);
	}
}
