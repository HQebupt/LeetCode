public class ExcelSheetColumnTitle {
	static char[] alp = new char[27];
	static {
		alp[1] = 'A';
		for (int i = 2; i < 27; i++) {
			alp[i] = (char) (alp[i - 1] + 1);
		}
	}
	// Time:O(n/26) Space:O(1)
	public String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
		return dfs(res, n);
	}

	private String dfs(StringBuilder res, int n) {
		if (n == 0) {
			return res.toString();
		}
		int div = n / 26;
		int mod = n % 26;
		if (mod == 0) {
			res.insert(0, alp[26]);
			div--;
		} else {
			res.insert(0, alp[mod]);
		}
		return dfs(res, div);
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle sol = new ExcelSheetColumnTitle();
		int n = 0 ;
		String res = sol.convertToTitle(n);
		System.out.println(res);
	}
}