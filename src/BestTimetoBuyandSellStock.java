public class BestTimetoBuyandSellStock {
	/**
	 * 一维动态规划：
	 * 全局最优：max
	 * 局部最优：local
	 * 保存最低的价格：min
	 * Time：O(n)  Space:O(1)
	 */
	public int maxProfit(int[] arr) {
		int len = arr.length;
		if (arr == null || len == 0)
			return 0;
		int local = 0, max = 0, min = arr[0];
		for(int i = 1; i < len; i++) {
			if (min > arr[i]) {
				min = arr[i];
				local = 0;
			} else {
				local = arr[i] - min;
				max = Math.max(max, local);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStock sol = new BestTimetoBuyandSellStock();
		int[] prices = { 2, 5, 1, 6, 9, 7 };
		int count = sol.maxProfit(prices);
		System.out.println(count);
	}
}
