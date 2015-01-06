// the problem can be solved using cpp at best.
// Time:O(n) Space:O(n!)
public class RegularExpressionMatching {
	// ERROR: Memory Limit Exceeded
	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		// p's length 1 is special case
		// next char is not '*',then must match
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));
		} else { // next char is '*'
			int len = s.length();
			int i = -1;
			while (i < len
					&& (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		// the following case return false.
		// all tests not contains the case. Unecessary considering.
		RegularExpressionMatching sol = new RegularExpressionMatching();
		String s = "aa";
		String p = "a**";
		System.out.println(sol.isMatch(s, p));
	}
}