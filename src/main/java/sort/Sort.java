package sort;

public class Sort {

	/**
	 * 2 归并排序
	 * 
	 * 1.将数组A不断的划分成左右2个数组，直到每个数组都只有1个数据`internalMergeSort`
	 * 
	 * 2.合并两个有序的数组`mergeSortedArray`
	 */
	public void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		internalMergeSort(arr, temp, 0, arr.length - 1);
	}

	private void internalMergeSort(int[] a, int[] temp, int left, int right) {
		// 当left==right的时，已经不需要再划分了
		if (left < right) {
			int middle = (left + right) / 2;
			internalMergeSort(a, temp, left, middle); // 左子数组
			internalMergeSort(a, temp, middle + 1, right); // 右子数组
			mergeSortedArray(a, temp, left, middle, right); // 合并两个子数组
		}
	}

	// 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
	private void mergeSortedArray(int arr[], int temp[], int left, int middle,
			int right) {
		int i = left;
		int j = middle + 1;
		int k = 0;
		while (i <= middle && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= middle) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		// 把数据复制回原数组
		for (i = 0; i < k; i++) {
			arr[left + i] = temp[i];
		}
	}

	/**
	 * 3 插入排序
	 */
	void insertSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1])
					swap(arr, j, j - 1);
				else
					break;// 因为数组前半段是有序的，所以只要有一次不需要swap的时候，后面的也不用swap了。
			}
		}
	}

	private void swap(int x[], int a, int b) {
		int t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	/**
	 * 4 冒泡排序
	 */
	void bubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = len - 1; j > i; j--) {
				if (arr[j] < arr[j - 1])
					swap(arr, j, j - 1);
			}
		}
	}

}
