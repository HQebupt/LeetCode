package offer;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution50 {
	// Solution 1: partition的思想
	// Time:O(n)  Space:O(1)
	// 居然说我超时，时间复杂度明显小于下面的。
	public ArrayList<Integer> getLeastNumbers(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>(k);
		int i = 0, j = arr.length - 1;
		while (true) {
			int q = partition(arr, i, j);
			if (k - 1 == q) {
				fill(res, arr, i, q);
				break;
			} else if (k < q) {
				j = q - 1;
			} else {
				fill(res, arr, i, q);
				i = q + 1;
			}
		}
		return res;
	}

	private void fill(ArrayList<Integer> res, int[] arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			res.add(arr[i]);
		}
	}

	private int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] <= x) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, r);
		return i + 1;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	/**
	 * Solution 2: TreeSet
	 * Time:O(n*logK) Space:O(k)
	 */
	public ArrayList<Integer> getLeastNumbers2(int[] arr, int k) {
		if(arr.length < k || k == 0) 
			return new ArrayList<Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int num : arr) {
			if (set.size() < k) {
				set.add(num);
			} else {
				Integer bigger = set.last();
				if (num < bigger) {
					set.remove(bigger);
					set.add(num);
				}
			}
		}
		return new ArrayList<Integer>(set);
	}
	
	public static void main(String[] args) {
		Solution50 sol = new Solution50();
		int[] arr = {4,5,1,6,2,7,3,8};
		int k = 8;
		System.out.println(sol.getLeastNumbers(arr, k));
	}
}