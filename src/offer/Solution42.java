package offer;

public class Solution42 {
	/**
	 * 数字在排序数组中出现的次数
	 * @param arr 排序数组
	 * @param num数字
	 * @return 次数
	 * 二分查找 Time:O(logn) Space:O(1) 
	 */
	
	public int getNumberOfK(int[] arr, int num) {
		int len = arr.length;
		int low = 0, high = len - 1;
		int count = 0;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (arr[mid] == num) {
				count++;
				for (int i = mid - 1; i >= 0; i--) {
					if(arr[i] == num) {
						count++;
					} else {
						break;
					}
				}
				for (int i =  mid + 1; i < len; i++) {
					if(arr[i] == num) {
						count++;
					} else {
						break;
					}
				}
				return count;
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return 0;
	}
}