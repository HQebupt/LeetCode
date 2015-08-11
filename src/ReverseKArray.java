import java.util.Arrays;

public class ReverseKArray {
	/**
	 * 题目：把数组的部分逆转 AB 逆转成 BA。(很简单的一个题目。和二分查找没有关系。)
	 * 题目大意：从k的位置反转数组
	 * 
	 * 思路1：先拷贝B的部分，在拷贝A的部分；最后把BA拷贝到原始数组。需要2次遍历数组，Time：O(n)，额外O(n)空间。
	 * 
	 * 思路2：BA = (A`B`)` --`理解为反转。每次都遍历一半的数组，所以一共相当于遍历了1次数组，Time：O(n)，
	 * 无额外的空间，复杂度 Space:O(1)
	 */
	void reverse(int[] num, int k) {
		int len = num.length;
		reversePart(num, 0, k);// A`
		reversePart(num, k + 1, len - 1);// B`
		reversePart(num, 0, len - 1);// (A`B`)`
	}

	private void reversePart(int[] num, int start, int end) {
		while (end > start) {
			swap(num, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		ReverseKArray sol = new ReverseKArray();
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 2;
		sol.reverse(num, k);
		System.out.println(Arrays.toString(num));
	}
}
