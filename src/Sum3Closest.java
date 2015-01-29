import java.util.Arrays;

public class Sum3Closest {
	
	// same as Sum3
	// Time: O(n^2)  Space:O(1)
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < num.length; i++) {
			int l = i + 1, r = num.length - 1;
			while (l < r) {
				int sum = num[i] + num[l] + num[r];
				int gap = Math.abs(target - sum);
				if (gap < min) {
					min = gap;
					result = sum;
				}
				if (sum < target) {
					l++;
				} else {
					r--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Sum3Closest sol = new Sum3Closest();
		int[] num = { 1,1,1,0};
		int target = -100;
		System.out.println(sol.threeSumClosest(num, target));
	}
}