import java.util.Arrays;
/**
 * 
 * @author HuangQiang
 * @date 2015-10-26上午10:02:52
 * @file SpiralMatrixII.java
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int count = n * n;
		int[][] res = new int[n][n];
		int start = 0, x0 = 0, y0 = 0, x1 = n - 1, y1 = n - 1;
		while (start != count) {
			if (x0 == x1 && (y0 == y1)) {
				res[x0][y0] = ++start;
				continue;
			}
			start = fillCircle(start, x0, y0, x1, y1, res);
			x0++;
			y0++;
			x1--;
			y1--;
		}
		return res;
	}

	private int fillCircle(int start, int x0, int y0, int x1, int y1, int[][] a) {
		// ---->
		for (int j = y0; j <= y1; j++) {
			a[x0][j] = ++start;
		}
		// |
		for (int i = x0 + 1; i < x1; i++) {
			a[i][y1] = ++start;
		}
		// <-----
		for (int j = y1; j >= y0; j--) {
			a[x1][j] = ++start;
		}
		// |
		for (int i = x1 - 1; i > x0; i--) {
			a[i][y0] = ++start;
		}
		return start;
	}

	public static void main(String[] args) {
		SpiralMatrixII sol = new SpiralMatrixII();
		int n = 4;
		int[][] res = sol.generateMatrix(n);
		for (int[] arr : res)
			System.out.println(Arrays.toString(arr));
	}

}
