public class UniquePaths {
	// Sol 1: DP Problem , Time O(m*n) Space O(m*n)
	public int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		// init
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		// dp[i][j] = dp[i-1][j] + dp[i,j-1]
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	// Sol 2: 单纯的DFS  Time O(n^4) Space(n)
	public int uniquePaths2(int m, int n) {
		if (m < 1 || n < 1)
			return 0;
		if (m == 1 && n == 1)
			return 1;
		return uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1);
	}

	// Sol 3: DFS + 缓存   Time O(n^2) Space O(n^2)
	
	//Sol 4: 数学公式解法  Time O(n^2!) Space(1)
	public static void main(String[] args) {
		UniquePaths sol = new UniquePaths();
		int m = 1;
		int n = 1;
		System.out.println(sol.uniquePaths(m, n));
	}
}