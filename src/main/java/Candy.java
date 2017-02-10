public class Candy {
	public int candy(int[] ratings) {
		final int len = ratings.length;
		int[] lefts = new int[len];
		int[] rights = new int[len];

		// scan from left to right
		lefts[0] = 1;
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) {
				lefts[i] = lefts[i - 1] + 1;
			} else {
				lefts[i] = 1;
			}
		}

		// scan from right to left
		rights[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				rights[i] = rights[i + 1] + 1;
			} else {
				rights[i] = 1;
			}
		}

		// calculate min nums of candy 
		int result = 0;
		for (int i = 0; i < len; i++) {
			result += Math.max(lefts[i], rights[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		Candy sol = new Candy();
		int[] ratings = { 3, 4, 5, 1, 2, 3 };
		int res = sol.candy(ratings);
		System.out.println(res);
	}
}