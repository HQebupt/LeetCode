package offer;

/**
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。 
 * 
 * 对比参考：Search a 2D Matrix leetcode
 * 
 * @date 2015-7-13
 */
public class Solution4 {

	/**
	 * 分析：一般会想到二分搜索的方法。
	 * 一开始将 target 与右上角的数来比较，就可以做到一次剔除一行或者一列。
	 * 
	 * 对于右上角的数字，如果 target更大，那么就剔除该数字所在行的左边数字，相当于此行；
	 * 如果 target更小，那么就剔除该数字所在列下面的数字，相当于此列。
	 */
	public boolean find(int[][] array, int target) {
		int row = array.length;
		int col = array[0].length;
		for (int i = 0, j = col - 1; (i < row) && (j >= 0);) {
			if (array[i][j] == target)
				return true;
			else if (array[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int[][] array = { { 1, 4, 5, 9 }, { 2, 6, 7, 12 }, { 10, 15, 16, 17 },
				{ 11, 20, 21, 22 } };
		int target = 3;
		System.out.println(sol.find(array, target));
	}
	// Refer: http://www.cnblogs.com/jianxinzhou/p/4492351.html
}
