import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	/**
	 * 矩阵的细节：一圈一圈的打印
	 * 单独处理一行的情况。
	 * 自己画个图就明白了。
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;
		int rows = matrix.length, column = matrix[0].length;
		int x0 = 0, y0 = 0, x1 = rows - 1, y1 = column - 1;
		for (; x0 <= x1 && (y0 <= y1); x0++, y0++, x1--, y1--) {
			if (x0 == x1) {
				for (int i = y0; i <= y1; i++) {
					res.add(matrix[x0][i]);
				}
			} else if (y0 == y1) {
				for (int i = x0; i <= x1; i++) {
					res.add(matrix[i][y0]);
				}
			} else {
				printHelp(matrix, x0, y0, x1, y1, res);
			}
		}
		return res;
	}

	/**
	 * 打印一圈的值
	 */
	private void printHelp(int[][] matrix, int x0, int y0, int x1, int y1,
			List<Integer> res) {
		for (int i = y0; i <= y1; i++) {
			res.add(matrix[x0][i]);
		}
		for (int i = x0 + 1; i <= x1; i++) {
			res.add(matrix[i][y1]);
		}
		for (int i = y1 - 1; i >= y0; i--) {
			res.add(matrix[x1][i]);
		}
		for (int i = x1 - 1; i > x0; i--) {
			res.add(matrix[i][y0]);
		}
	}

	public static void main(String[] args) {
		SpiralMatrix sol = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		System.out.println(sol.spiralOrder(matrix));
	}
}