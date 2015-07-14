package offer;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 
 * @date 2015-7-14
 */
public class Solution9 {
	/**
	 * 观察一下数组的特性
	 * 对于一般的情况，假设A为输入数组，left 和 right 为数组左右边界的坐标，
	 * 考察中间位置的值A[mid] ，如果A[mid] > A[right]，表明最小值处于右半段。调整left = mid；
	 * 如果A[mid]<A[right]，表明最小值处于左半段。因此调整左边界right = mid。
	 * 当左右边界相邻时，较小的一个就是数组的最小值。
	 */
	// java 代码超时了，不知道为什么
	// 对于{ 1, 1, 1, 0, 1}有重复的测试用例，有问题。细节部分还要细化。
	public int minNumberInRotateArray(int[] array) {
		int left = 0, right = array.length - 1;
		while (right - left > 1) {
			int mid = (left + right) >> 1;
			if (array[mid] >= array[right]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		int min = array[left] < array[right] ? array[left] : array[right];
		return min;
	}

	public static void main(String[] args) {
		Solution9 sol = new Solution9();
		int[] array = { 1, 1, 1, 0, 1};
		System.out.println(sol.minNumberInRotateArray(array));
	}
}
