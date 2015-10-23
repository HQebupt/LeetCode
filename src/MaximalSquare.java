import java.util.Arrays;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			return 0;
		}
		int col = matrix[0].length;
		int[][] dp = new int[row][col];
		int resMax = 0;
		for (int i = 0; i < row; i++) {
			dp[i][0] = matrix[i][0] - '0';
			resMax = Math.max(resMax, dp[i][0]);
		}
		for (int i = 0; i < col; i++) {
			dp[0][i] = matrix[0][i] - '0';
			resMax = Math.max(resMax, dp[0][i]);
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
					resMax = Math.max(resMax, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		// System.out.println("dp数组：");
		// for (int i = 0; i < row; i++)
		// System.out.println(Arrays.toString(dp[i]));
		return resMax * resMax;
	}

	private int min(int a, int b, int c) {
		int minLen = a < b ? a : b;
		minLen = minLen < c ? minLen : c;
		return minLen;
	}

	public static void main(String[] args) {
		MaximalSquare sol = new MaximalSquare();
		char[][] matrix = { { '1', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1' } };
		System.out.println(sol.maximalSquare(matrix));
	}

}