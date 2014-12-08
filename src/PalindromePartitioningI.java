import java.util.ArrayList;
import java.util.List;

// DP 求解。Time: O(n^2) Space: O(n)
public class PalindromePartitioningI {
	public List<List<String>> partition(String s) {
		char[] cs = s.toCharArray();
		int len = s.length();
		List<List<List<String>>> subs = new ArrayList<List<List<String>>>();
		for (int i = 0; i < len; i++) {
			List<List<String>> sub = new ArrayList<List<String>>();
			subs.add(sub);
		}
		boolean[][] p = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				p[i][j] = cs[i] == cs[j] && (j - i < 2 || p[i + 1][j - 1]);
			}
		}
		// the bolow is init.
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (p[i][j]) {
					String tmp = s.substring(i, j + 1);
					if (j + 1 < len) {
						for (List<String> sub : subs.get(j + 1)) {
							List<String> arr = new ArrayList<String>(sub);
							arr.add(0, tmp);
							subs.get(i).add(arr);
							System.out.println(arr);
						}
					} else {
						List<String> arr = new ArrayList<String>(1);
						arr.add(0, tmp);
						subs.get(i).add(arr);
					}
				}
			}
		}
		return subs.get(0);

	}

	public static void main(String[] args) {
		PalindromePartitioningI sol = new PalindromePartitioningI();
		String s = "cbaab";
		List<List<String>> res = sol.partition(s);
		System.out.println(res);
	}
}
