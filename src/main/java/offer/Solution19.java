package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 顺时针打印矩阵
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 
 * @author HuangQiang
 * @date 2015-7-27下午09:01:24
 * @file Solution19.java
 * 
 *       思路：循环条件怎么判定？一个矩阵，给定起点（x0，y0）和终点（x1，y1）（即位于对角线上的两个点）就可以打印一周，
 *       然后向里进一周（即x0++,y0++,x1--,y1--）即可，如果起始点坐标>终止点坐标（即 x0 > x1 或者y0 > y1）循环结束。
 *       
 *       如何打印一周的值呢？自己画个图，会发现4个循环就可以了。
 *       
 *       注意：对于单独的一行或者一列要单独打印。
 */
public class Solution19 {

	// Solution 不完善---- 顺时针打印:没考虑到单独一行和一列的情况
	public List<Integer> printMatrix0(int[][] matrix) {
		int x0 = 0, y0 = 0;
		int x1 = matrix.length - 1, y1 = matrix[0].length - 1;
		List<Integer> result = new LinkedList<Integer>();
		for (; (x0 < x1) && (y0 < y1); x0++, y0++, x1--, y1--) {
			for (int y = y0; y <= y1; y++) {
				result.add(matrix[x0][y]);
			}
			for (int x = x0 + 1; x <= x1; x++) {
				result.add(matrix[x][y1]);
			}
			for (int y = y1 - 1; y >= y0; y--) {
				result.add(matrix[x1][y]);
			}
			for (int x = x1 - 1; x >= x0 + 1; x--) {
				result.add(matrix[x][y0]);
			}
		}
		return result;
	}

	// Solution 1
	// 顺时针打印：单独处理一行一列的情况；借助printHelp函数，打印可以围成一圈的矩阵。
	public List<Integer> printMatrix(int[][] matrix) {
		int x0 = 0, y0 = 0;
		int x1 = matrix.length - 1, y1 = matrix[0].length - 1;
		List<Integer> result = new LinkedList<Integer>();
		for (; (x0 <= x1) && (y0 <= y1); x0++, y0++, x1--, y1--) {
			if (x0 == x1) {
				for (int y = y0; y <= y1; y++) {
					result.add(matrix[x0][y]);
				}
			} else if (y0 == y1) {
				for (int x = x0; x <= x1; x++) {
					result.add(matrix[x][y0]);
				}

			} else {
				printHelp(matrix, result, x0, y0, x1, y1);
			}
		}
		return result;
	}

	public void printHelp(int[][] matrix, List<Integer> result, int x0, int y0,
			int x1, int y1) {
		for (int y = y0; y <= y1; y++) {
			result.add(matrix[x0][y]);
		}
		for (int x = x0 + 1; x <= x1; x++) {
			result.add(matrix[x][y1]);
		}
		for (int y = y1 - 1; y >= y0; y--) {
			result.add(matrix[x1][y]);
		}
		for (int x = x1 - 1; x >= x0 + 1; x--) {
			result.add(matrix[x][y0]);
		}
	}

	public static void main(String[] args) {
		Solution19 sol = new Solution19();
		int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		System.out.println(sol.printMatrix(matrix));
	}

}
