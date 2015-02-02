/**
 * Reference: 
 * http://blog.csdn.net/linhuanmars/article/details/24066199
 * http://www.cnblogs.com/springfor/p/3888003.html
 */
public class SetMatrixZeroes {
	// Solution 1: m + n 的空间储存是否一行一列有0.
	// Time: O(m * n) Space: O(m + n)
	public void setZeroes(int[][] matrix) {
		int rlen = matrix.length;
		int clen = matrix[0].length;
		boolean[] row0 = new boolean[rlen];
		boolean[] col0 = new boolean[clen];

		// find the 0 row and 0 column.
		for (int i = 0; i < rlen; i++) {
			for (int j = 0; j < clen; j++) {
				if (matrix[i][j] == 0) {
					row0[i] = true;
					col0[j] = true;
				}
			}
		}

		// fill 0s for row and column.
		for (int i = 0; i < rlen; i++) {
			for (int j = 0; j < clen; j++) {
				if (row0[i] || col0[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// Solution 2: 减少到常数的空间复杂度,复用输入矩阵的第一行和第一列来储存一行一列是否有0.
	// Time: O(m * n)  Space: O(1)
	public void setZeroes2(int[][] matrix) {
		int rlen = matrix.length;
		int clen = matrix[0].length;
		boolean row1st = false, col1st = false; // 第一行 、 第一列是否有0

		// first row has 0 or not
		for (int j = 0; j < clen; j++) {
			if (matrix[0][j] == 0) {
				row1st = true;
				break;
			}
		}
		// first column has 0 or not
		for (int i = 0; i < rlen; i++) {
			if (matrix[i][0] == 0) {
				col1st = true;
				break;
			}
		}

		// 利用第一列和第一行来记录每一行和列是否有0: matrix[0][j] 记录j列有0; matrix[i][0] 记录i行有0.
		for (int i = 1; i < rlen; i++) {
			for (int j = 1; j < clen; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 除了第1行、第1列，符合条件的就填入0
		for (int i = 1; i < rlen; i++) {
			for (int j = 1; j < clen; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// 处理第1行、第1列
		if (row1st) {
			for (int j = 0; j < clen; j++) {
				matrix[0][j] = 0;
			}
		}
		if (col1st) {
			for (int i = 0; i < rlen; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
