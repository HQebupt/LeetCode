public class SortColors {
	// Solution 1 : Counting sort. 
	// two pass
	// Time: O(2*n)  Space: O(1)
	public void sortColors(int[] A) {
		int[] count = new int[3];
		for (int i = 0; i < A.length; i++) {
			count[A[i]]++;
		}
		int pos = 0;
		for (int j = 0; j < 3; j++)
			for (int i = 0; i < count[j]; i++)
				A[pos++] = j;
	}
	
	
	// Solution 2: two pointer
	// Time: O(n)  Space: O(1)
	public void sortColors2(int[] A) {
		int red = 0, blue = A.length - 1;
		for (int i = 0; i < blue + 1;) {
			switch(A[i]){
				case 0:
					int tmp = A[red];
					A[red] = A[i];
					A[i] = tmp;
					red++;
					i++;
					break;
				case 1:
					i++;
					break;
				case 2:
					int tmp1 = A[blue];
					A[blue] = A[i];
					A[i] = tmp1;
					blue--;
					break;
				default:
					break;
			}
		}
	}
	
	// Solution 3: partition
	// Todo
}
