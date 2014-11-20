public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int xlen = grid.length;
		int ylen = grid[0].length;
		int dp[][] = new int[xlen][ylen];
		// init dp[][]
		dp[0][0] = grid[0][0];
		for (int i = 1; i < xlen; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < ylen; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		// Dynamic Programming 公式：
		// dp[i][j] = min{dp[i-1[j], dp[i][j-1]} + grid[i][j]
		for (int i = 1; i < xlen; i++)
			for (int j = 1; j < ylen; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		return dp[xlen - 1][ylen - 1];
	}

	public static void main(String[] args) {
		MinimumPathSum sol = new MinimumPathSum();
		int[][] grid = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		System.out.println(sol.minPathSum(grid));
	}
}