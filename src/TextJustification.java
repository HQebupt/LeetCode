import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		int length = words.length;
		ArrayList<String> reslist = new ArrayList<String>();
		int lenTotal = 0;
		ArrayList<String> unit = new ArrayList<String>();
		for (int i = 0; i < length; i++) {
			int len = words[i].length();
			if (lenTotal + len <= L) {
				lenTotal += len + 1;
				unit.add(words[i]);
			} else {
				String str = setJustify(unit, lenTotal, L);
				reslist.add(str);
				lenTotal = len + 1;
				unit.clear();
				unit.add(words[i]);
			}
		}
		String str = lastLine(unit, lenTotal, L);
		reslist.add(str);
		return reslist;
	}

	private String lastLine(ArrayList<String> unit, int lenTotal, int L) {
		int size = unit.size();
		String str = "";
		for (int i = 0; i < size - 1; i++)
			str += unit.get(i) + " ";
		str += unit.get(size - 1);
		int lenStr = str.length();
		for (int j = 0; j < L - lenStr; j++) {
			str += " ";
		}
		return str;
	}

	private String setJustify(ArrayList<String> unit, int lenTotal, int L) {
		int size = unit.size();
		int totalBlank = L - (lenTotal - size);
		String str = "";
		if (size > 1) {
			int[] blank = new int[size - 1];
			int div = totalBlank / blank.length;
			int mod = totalBlank % blank.length;
			for (int i = 0; i < blank.length; i++) {
				blank[i] = div;
			}
			for (int i = 0; i < mod; i++) {
				blank[i] += 1;
			}
			for (int i = 0; i < size; i++) {
				str += unit.get(i);
				for (int j = 0; (i < blank.length) && (j < blank[i]); j++) {
					str += " ";
				}
			}
		} else {
			str = unit.get(0);
			for (int j = 0; j < totalBlank; j++) {
				str += " ";
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String[] words = { "" };
		int L = 0;
		TextJustification sol = new TextJustification();
		List<String> res = sol.fullJustify(words, L);
		System.out.println(res);
	}
}