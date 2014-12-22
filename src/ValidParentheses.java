import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Time:O(n) Space:O(n) 
public class ValidParentheses {
    final static char[] PRE = { '(', '[', '{' };
    final static char[] SUF = { ')', ']', '}' };
    static Map<Character, Character> map = new HashMap<Character, Character>();

    public boolean isValid(String s) {
	for (int i = 0; i < 3; i++) {
	    map.put(PRE[i], SUF[i]);
	}
	LinkedList<Character> stack = new LinkedList<Character>();
	char[] chs = s.toCharArray();
	for (int i = 0; i < chs.length; i++) {
	    if (inPre(chs[i])) {
		stack.add(chs[i]);
	    } else {
		if (!stack.isEmpty()) {
		    char ch = stack.removeLast();
		    if (map.get(ch) != chs[i])
			return false;
		} else {
		    return false;
		}
	    }
	}
	return stack.isEmpty();
    }

    private boolean inPre(char c) {
	for (char ch : PRE) {
	    if (ch == c)
		return true;
	}
	return false;
    }

    public static void main(String[] args) {
	ValidParentheses sol = new ValidParentheses();
	String s = "()[]{}";
	boolean res = sol.isValid(s);
	System.out.println(res);
    }
}