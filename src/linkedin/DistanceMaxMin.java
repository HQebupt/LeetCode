package linkedin;

import java.util.Arrays;
import java.util.Comparator;

public class DistanceMaxMin {

	// first problem
	int minDistance(int[] A) {
		final int len = A.length;
		Arrays.sort(A);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < len; i++) {
			int gap = Math.abs(A[i] - A[i - 1]);
			min = min < gap ? min : gap;
		}
		System.out.println(min);
		return min;
	}

	// Second problem
	int maxDistance(int[] A) {
		final int len = A.length;
		Comparator<Comb> cmp = new Comparator<DistanceMaxMin.Comb>() {
			@Override
			public int compare(Comb o1, Comb o2) {
				return o1.val - o2.val;
			}
		};
		Comb[] aCombs = new Comb[len];
		for (int i = 0; i < len; i++) {
			aCombs[i] = new Comb(A[i], i);
		}
		Arrays.sort(aCombs,cmp);
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < len; i++) {
			int gap = Math.abs(aCombs[i].index - aCombs[i - 1].index);
			max = max > gap ? max : gap;
		}
		return max;
	}

	static class Comb {
		int val, index;

		public Comb(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		DistanceMaxMin sol = new DistanceMaxMin();
		int[] A = { 1, 3, 5, 2};
		System.out.println(sol.maxDistance(A));
	}

}
