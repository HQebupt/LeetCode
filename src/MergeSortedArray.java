import java.util.Arrays;

//时间复杂度：O(m+n) 空间复杂度:0(1)
public class MergeSortedArray {
	// 这是标准的模板写法，由于题目说数组a可以容纳下所有的元素，
	// 所以从数组a和b的最后一位往前比较。
	public void merge(int a[], int m, int b[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && (j >=0)) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while (j >=0) {
			a[k--] = b[j--];
		}
	}
	
	public static void main(String[] args) {
		MergeSortedArray sol = new MergeSortedArray();
		int alen = 7, n = 3;
		int[] a = new int[alen];
		for(int i = 0; i < 4; i++) {
			a[i] = (i+1) * 2;
		}
		int[] b = {1,3,5};
		sol.merge(a, 4, b, n);
		System.out.println(Arrays.toString(a));
	}

}