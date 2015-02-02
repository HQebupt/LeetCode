public class RotateImage {
	// Solution 1: 利用转置矩阵
	// Time: O(n) Space: O(1)
	// 200ms
	public void rotate(int[][] matrix) {
		final int n = matrix.length;
		// Step 1 转置矩阵 : (i,j) 与 (j,i)交换
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				final int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		// Step 2 旋转90的矩阵 : each line reverse
		for (int i = 0, half = n >> 1; i < n; i++) {
			for (int j = 0; j < half; j++) {
				final int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = tmp;
			}
		}
	}

	// Solution 2: 副对角线、水平线翻转
	// Time: O(n) Space: O(1)
	// 178ms
	public void rotate1(int[][] matrix) {
		final int n = matrix.length;
		// Step 1 副对角线翻转
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				final int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
				matrix[n - 1 - j][n - 1 - i] = tmp;
			}
		}
		// Step 2 水平线翻转
		final int half = n >> 1;
		for (int i = 0; i < half; i++) {
			for (int j = 0; j < n; j++) {
				final int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		RotateImage sol = new RotateImage();
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		sol.rotate1(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}