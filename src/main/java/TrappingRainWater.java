public class TrappingRainWater {
	// Solution 1
	// Time:O(n) Space:O(n)
	public int trap(int[] A) {
		int len = A.length;
		int[] lMax = new int[len];
		int[] rMax = new int[len];
		for (int i = 1; i < len; i++) {
			lMax[i] = Math.max(lMax[i - 1], A[i - 1]);
			rMax[len - i - 1] = Math.max(rMax[len - i], A[len - i]);
		}
		int water = 0;
		for (int i = 0; i < len; i++) {
			int height = Math.min(lMax[i], rMax[i]);
			if (height > A[i])
				water += height - A[i];
		}
		return water;
	}
	// Solution 2
	// Time:O(n) Space:O(1)
	public int trap2(int[] A) {
		int len = A.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			max = A[max] > A[i] ? max : i;
		}
		int water = 0;
		
		// at the left of max position.
		int peak = 0; // current water level.
		for (int i = 0; i < max; i++) {
			if(A[i] > peak)
				peak = A[i];
			else
				water += peak - A[i];
		}
		// at the right of max position.
		peak = 0;
		for (int i = len - 1; i > max; i--) {
			if(A[i] > peak)
				peak = A[i];
			else
				water += peak - A[i];
		}
		return water;
	}

	public static void main(String[] args) {
		int[] a = { 0,2,0 };
		TrappingRainWater sol = new TrappingRainWater();
		System.out.println(sol.trap2(a));
	}
}