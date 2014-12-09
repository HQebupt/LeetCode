// DP Time: O(n^2) Space: O(n^2)
public class PalindromePartitioningII {
	public int minCut(String s) {
		char[] cs = s.toCharArray();
		int len = s.length();
		int[] cuts = new int[len + 1];
		for (int i = len; i >= 0; i--) {
			cuts[i] = len - i - 1;
		}
		boolean[][] p = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				p[i][j] = cs[i] == cs[j] && (j - i < 2 || p[i + 1][j - 1]);
				if (p[i][j]) {
					cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
				}
			}
		}
		return cuts[0];
	}

	public static void main(String[] args) {
		PalindromePartitioningII sol = new PalindromePartitioningII();
		String s = "ababababababababababababababafbabababa";
		int res = sol.minCut(s);
		System.out.println(res);
	}
}
