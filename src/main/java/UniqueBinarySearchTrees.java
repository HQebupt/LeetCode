public class UniqueBinarySearchTrees {
	// 卡特兰数，一维动态规划，如果用卡特兰公式解的话，时间复杂度可以减少到O(n).
	// Reference： Code Ganker征服代码
	// Time:O(n^2) Space:O(n)
	public int numTrees(int n) {
		int len = n + 1; // 根据结果看，需要catalen[n]的值，需要申请 n + 1的空间。
		int[] catalan = catalen(len);
		return catalan[n];
	}

	// 卡特兰数的模板代码
	// C[0]-C[5] = {1, 1, 2, 5, 14}
	private int[] catalen(int len) {
		int[] cata = new int[len];
		cata[0] = 1;
		for (int n = 0; n < len - 1; n++) {
			for (int i = 0; i <= n; i++) {
				cata[n + 1] += cata[i] * cata[n - i];
			}
		}
		return cata;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
		int n = 3;
		System.out.println(sol.numTrees(n));
	}
}
