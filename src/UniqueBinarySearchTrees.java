public class UniqueBinarySearchTrees {
	// 卡特兰数，一维动态规划，如果用卡特兰公式解的话，时间复杂度可以减少到O(n).
	// Reference： Code Ganker征服代码
	// Time:O(n^2)  Space:O(n)
	public int numTrees(int n) {
		int[] catalan = new int[n + 1];
		catalan[0] = 1;
		catalan[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];
			}
		}
		return catalan[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
		int n = 4;
		System.out.println(sol.numTrees(n));
	}
}
