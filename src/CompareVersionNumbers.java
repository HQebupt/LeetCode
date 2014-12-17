public class CompareVersionNumbers {
	// Time O(n) Space O(n)
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int maxlen = s1.length > s2.length ? s1.length : s2.length;
		int[] value1 = new int[maxlen];
		int[] value2 = new int[maxlen];
		int cmp = 0;
		for (int i = 0; i < s1.length; i++) {
			value1[i] = parseToNumber(s1[i]);
		}
		for (int i = 0; i < s2.length; i++) {
			value2[i] = parseToNumber(s2[i]);
		}
		for (int i = 0; i < maxlen; i++) {
			cmp = value1[i] > value2[i] ? 1 : (value1[i] < value2[i] ? -1 : 0);
			if (cmp != 0) {
				break;
			}
		}
		return cmp;
	}

	private int parseToNumber(String s) {
		if (s.equals(""))
			return 0;
		else
			return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		CompareVersionNumbers sol = new CompareVersionNumbers();
		String v1 = "1.1";
		String v2 = ".1.1";
		System.out.println(sol.compareVersion(v1, v2));

	}
}