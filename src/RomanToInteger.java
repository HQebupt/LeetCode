import java.util.HashMap;
import java.util.Map;

// Time: O(n) Space: O(1)
public class RomanToInteger {
    private final static Map<Character, Integer> MAP = new HashMap<Character, Integer>();
    static {
	char[] r = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
	int[] v = { 1000, 500, 100, 50, 10, 5, 1 };
	for (int i = 0; i < r.length; i++) {
	    MAP.put(r[i], v[i]);
	}
    }

    public int romanToInt(String s) {
	int len = s.length();
	int previous = Integer.MAX_VALUE;
	int result = 0;
	for (int i = 0; i < len; i++) {
	    int curr = MAP.get(s.charAt(i));
	    result += curr;
	    if (curr > previous)
		result -= 2 * previous;
	    previous = curr;
	}
	return result;
    }

    public static void main(String[] args) {
	RomanToInteger sol = new RomanToInteger();
	String s = "MCDXXXVII"; // 1437
	System.out.println(sol.romanToInt(s));
    }
}
