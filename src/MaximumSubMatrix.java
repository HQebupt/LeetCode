public class MaximumSubMatrix {

	/**
	 * 在二维矩阵中，寻找和最大的子矩阵。（最大子数组和的升级版）
	 * 
	 * 思路：思路类似，压缩多行为一行，变成一维的问题。
	 */

	public int maxSubMatrix(int[][] matrix) {
		int row = matrix.length, column = matrix[0].length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = i; j < row; j++) {
				// 合并一维数组
				int[] tmp = new int[column];
				for (int p = 0; p < column; p++)
					tmp[p] = 0;

				for (int k = 0; k < column; k++) {
					for (int t = i; t <= j; t++) {
						tmp[k] += matrix[t][k];
					}
				}

				// 求最大值
				int local = maxSubArray(tmp);
				max = max > local ? max : local;
			}
		}
		return max;
	}

	private int maxSubArray(int[] arr) {
		int len = arr.length;
		int max = arr[0], local = arr[0];

		for (int i = 1; i < len; i++) {
			local = Math.max(arr[i], arr[i] + local);
			max = max > local ? max : local;
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSubMatrix sol = new MaximumSubMatrix();
		int[][] matrix = { { -1, 1, 1, 1 }, { -1, 1, 1, 1 } };
		System.out.println(sol.maxSubMatrix(matrix));
	}

}
