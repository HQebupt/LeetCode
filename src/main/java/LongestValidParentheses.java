import java.util.LinkedList;

// Time:O(n) Space:O(n)
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int len = s.length();
		LinkedList<Integer> index = new LinkedList<Integer>();
		int max = 0, last = -1;
		// last: the position of the last ')'. ****important****
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				index.push(i);
			} else {
				if (index.isEmpty())
					last = i;
				else {
					index.pop();
					if (index.isEmpty())
						max = max > i - last ? max : i - last;
					else {
						int left = index.peek();
						max = max > i - left ? max : i - left;
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestValidParentheses sol = new LongestValidParentheses();
		String s = "()(())";
		int res = sol.longestValidParentheses(s);
		System.out.println(res);
	}
}