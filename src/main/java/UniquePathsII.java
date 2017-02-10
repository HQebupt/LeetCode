public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int xlen = obstacleGrid.length;
		int ylen = obstacleGrid[0].length;
		int[][] dp = new int[xlen][ylen];

		// init
		for (int i = 0; i < xlen; i++) {
			if (i == 0)
				dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
			else
				dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
		}
		for (int j = 0; j < ylen; j++) {
			if (j == 0)
				dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : 1;
			else
				dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
		}

		// dp[i,j] = grid[i,j] == 1 ? 0 : sum(dp[i - 1,j] + dp[i,j - 1])
		for (int i = 1; i < xlen; i++)
			for (int j = 1; j < ylen; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j]
						+ dp[i][j - 1];
			}

		return dp[xlen - 1][ylen - 1];
	}

	public static void main(String[] args) {
		UniquePathsII sol = new UniquePathsII();
		int[][] obstacleGrid = { { 0, 0, 1, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
	}
}