import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
	// 灵感来自于Largest Rectangle in  Histogram这道题，
	// 假设我们把矩阵沿着某一行切下来，然后把切的行作为底面，将自底面往上的矩阵看成一个直方图（histogram）。
	// 直方图的中每个项的高度就是从底面行开始往上1的数量。
	// Time:O(m * n)
	public int maximalRectangle(char[][] matrix) {
		int result = 0;
		int row = matrix.length;
		if (matrix == null || row == 0) {
			return result;
		}
		int col = matrix[0].length; // O(n)空间
		int[] height = new int[col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '0') {
					height[j] = 0;
				} else {
					height[j] += 1;
				}
			}
			result = Math.max(result, largestRectangleArea(height));
		}
		return result;
	}

	private int largestRectangleArea(int[] height) {
		int result = 0;
		int len = height.length;
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < len;) {
			if (stack.isEmpty() || height[stack.peek()] < height[i]) {
				stack.push(i);
				i++;
			} else {
				int tmp = stack.pop();
				int count = stack.isEmpty() ? i : i - stack.peek() - 1;
				result = Math.max(result, count * height[tmp]);
			}
		}

		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			int count = stack.isEmpty() ? len : len - stack.peek() - 1;
			result = Math.max(result, count * height[tmp]);
		}
		return result;
	}

	public static void main(String[] args) {
		MaximalRectangle sol = new MaximalRectangle();
		char[][] matrix = { { '0', '0', '0', '0' }, { '1', '1', '1', '1' },
				{ '1', '1', '1', '0' }, { '0', '1', '0', '0' } };
		System.out.println(sol.maximalRectangle(matrix));
	}
}