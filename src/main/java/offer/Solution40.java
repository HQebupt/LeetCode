package offer;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution40 {
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array.length < 2) {
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		
		// 找出分界的值partition
		int key = 0;
		for (int num : array) {
			key = key ^ num;
		}
		int partition = 1;
		for(int tmp = key & 1; tmp != 1;) {
			partition = partition << 1;
			key = key >>> 1;
			tmp = key & 1;
		}
		
		// 将数组划分成两个子数组，把两个仅出现一次的数，分开放在两个子数组里面。
		int i = -1;
		for (int j = 0; j < array.length; j++) {
			if ((array[j] & partition) == partition) {
				i++;
				swap(array, i, j);
			}
		}
		
		// 在两个子数组里面分开求单独的一个数。
		int mid = i;
		num1[0] = 0;
		num2[0] = 0;
		for(int j = 0; j <= mid; j++) {
			num1[0] = num1[0] ^ array[j];
		}
		
		for(int j = mid + 1; j < array.length; j++) {
			num2[0] = num2[0] ^ array[j];
		}

	}
	
	private void swap (int[] a, int i ,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		Solution40 sol = new Solution40();
		int[] array = { 2, 1, 3, 6, 3, 2, 5, 5};
		int[] num1 = {0};
		int[] num2 = {0};
		sol.findNumsAppearOnce(array, num1, num2);
		System.out.println("num1:" + num1[0] + "  num2:" + num2[0]);
	}
}