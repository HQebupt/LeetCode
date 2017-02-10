package offer;

import java.util.LinkedList;

/**
 * 调整数组顺序使奇数位于偶数前面 
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分， 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 注意：指的是数组里面的元素本身的奇偶性，不是数组的下标
 * @date 2015-7-16
 */
public class Solution13 {
	// 弱化题目条件的解法
	// 不考虑奇数和奇数，偶数和偶数之间的相对位置的变化，可以使用两个前后指针来做。
	// front: 指向开头的偶数; end:指向结尾的奇数。
	// Time:O(n)
	public void reOrderArray0(int[] array) {
		int front = 0, end = array.length - 1;
		while (front < end) {
			while ((array[front] & 1) != 0) {
				front++;
			}
			while ((array[end] & 1) == 0) {
				end--;
			}
			if (front < end) {
				int tmp = array[front];
				array[front] = array[end];
				array[end] = tmp;
			}
		}
	}
	
	/*
	 *  Solution : 用额外的空间存储，Time：O(n) Space：O(n)
	 *  1） 先构建两个单链表,一个用来存放数组中奇数，一个用来存放数组中的偶数；
	 *  2） 然后先将所有奇数拷回到原数组中，再将所有偶数拷回到原数组中。
	 *  参考：http://blog.csdn.net/pengyan0812/article/details/46358275
	 */
	public void reOrderArray(int[] array) {
		LinkedList<Integer> odd = new LinkedList<Integer>();
		LinkedList<Integer> even = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) != 0) {
				odd.add(array[i]);
			} else {
				even.add(array[i]);
			}
		}
		int i = 0;
		for (int e : odd) {
			array[i++] = e;
		}
		for (int e : even) {
			array[i++] = e;
		}
	}
	

	public static void main(String[] args) {
		Solution13 sol = new Solution13();
		int[] array = { 2,4,6,1,3,5,7};
		sol.reOrderArray(array);
		for (int a : array) {
			System.out.println(a);
		}
	}

}
