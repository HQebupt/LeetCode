// Time: O(n) Space:O(n)
// 如果寻找规律可以将空间的复杂度为O(1)
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		StringBuilder[] sb = new StringBuilder[nRows];
		for (int i = 0; i < nRows; i++) {
			sb[i] = new StringBuilder();
		}
		int size = s.length();
		int len = build(nRows) + nRows;
		int index = 0;
		while (index < size) {
			for (int k = 0; k < nRows && (index < size); k++) {
				sb[k].append(s.charAt(index));
				index++;
			}
			for (int k = 0; k < len - nRows && (index < size); k++) {
				int pos = len - nRows - (index % len) % nRows;// 斜对角的元素
				sb[pos].append(s.charAt(index));
				index++;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			res.append(sb[i]);
		}
		return res.toString();
	}

	private int build(int n) {
		return n - 2 > 0 ? n - 2 : 0;
	}

	public static void main(String[] args) {
		ZigZagConversion sol = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int nRows = 4;
		String res = sol.convert(s, nRows);
		System.out.println(res);
	}
}