import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {
	// Time:O(n) Space:O(n)
	// Hash Table
	public List<String> anagrams(String[] strs) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> result = new LinkedList<String>();
		for (int i = 0; i < strs.length; i++) {
			String s = getSortStr(strs[i]);
			if (map.containsKey(s)) {
				int found = map.get(s);
				if (found != -1) {
					result.add(strs[found]);
					map.put(s, -1);
				}
				result.add(strs[i]);
			} else {
				map.put(s, i);
			}
		}
		return result;
	}

	private String getSortStr(String str) {
		char[] tmp = str.toCharArray();
		Arrays.sort(tmp);
		String s = new String(tmp);
		return s;
	}

	public static void main(String[] args) {
		Anagrams sol = new Anagrams();
		String[] strs = { "sow", "map", "pam", "nat" };
		System.out.println(sol.anagrams(strs));
	}
}
