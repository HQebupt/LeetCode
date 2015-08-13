package sort;

import java.util.Arrays;

public class HeapSort {

	/**
	 * 堆排序
	 * @param arr  待排序的数组
	 */
	public void heapsort(int arr[]) {
		int len = arr.length;
		// 第1步：初始化堆
		for (int i = len / 2 - 1; i >= 0; i--) {
			reheap(arr, i, len - 1);
		}
		
		// 循环i : len - 1 to 0 ( i>=1 也可以)
		for (int i = len - 1; i >= 0; i--) {
			swap(arr, 0, i); // 第2步：移除最大的堆顶 (arr[0]始终是最大的)
			reheap(arr, 0, i - 1); // 第3步：剩下的无序区范围(0, i - 1)
		}
	}

	/**
	 * 堆调整：把i-j的数组建立成一个堆
	 * 注意循环条件
	 * @param arr  待排序的数组
	 * @param i 起始位置
	 * @param j 截止位置 
	 * left 左子，right 右子, max 起始赋值为 left，反正是要找左右子最大的。
	 * left = 2 * i + 1, right = left + 1
	 */
	private void reheap(int arr[], int i, int j) {
		int max = 2 * i + 1; // i的left节点
		while (max <= j) {
			// 1.节点与左右节点最大的，放在根结点上。
			int right = max + 1;
			if ((right <= j) && (arr[right] > arr[max])) { // 右子树若存在，找max。
				max = right;
			}
			// 2. 如果调整过节点和max的位置，看max所代表的子节点是否构成堆。
			if (arr[i] < arr[max]) { 
				swap(arr, i, max);
				max = 2 * max + 1;
			} else { // 3.如果没有发生调整，那么说明整个堆已经调整成功了。直接返回
				return;
			}
		}
	}
	
	// 交换数组的2个元素
	private void swap(int heap[], int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public static void main(String[] args) {
		int arr[] = { 20, 40, 30, 10, 90, 70 };
		HeapSort sol = new HeapSort();
		sol.heapsort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
