import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	// Time:O(n)  Space:O(n)
	private final static Map<Character, Integer> chsMap = new HashMap<Character, Integer>(
			4);
	static {
		chsMap.put('A', 0);
		chsMap.put('C', 1);
		chsMap.put('G', 2);
		chsMap.put('T', 3);
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> res = new HashSet<String>();
		final int length = s.length();
		if (length <= 10)
			return new LinkedList<String>(res);
		Set<Integer> intSet = new HashSet<Integer>();
		int value = 0;
		for (int i = 0; i < 9; i++) {
			value = (value << 2) + chsMap.get(s.charAt(i));
		}
		for (int i = 9; i < length; i++) {
			value = (value << 2) + chsMap.get(s.charAt(i));
			value &= (1 << 20) - 1;
			if (intSet.contains(value)) {
				res.add(s.substring(i - 9, i + 1));
			}
			intSet.add(value);
		}
		return new LinkedList<String>(res);
	}

	public static void main(String[] args) {
		RepeatedDNASequences sol = new RepeatedDNASequences();
		String s = "AAAAAAAAAAAAAA";
		System.out.println(sol.findRepeatedDnaSequences(s));
	}
}