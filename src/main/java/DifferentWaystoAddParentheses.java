import java.util.LinkedList;
import java.util.List;
/**
 * @author HuangQiang
 * @date 2015-10-26下午04:31:14
 * @file DifferentWaystoAddParentheses.java
 */
public class DifferentWaystoAddParentheses {
	/**
	 * 递归分治来解
	 * @param input = "2-1-1"
	 * @return res = { 2, 0 }
	 */
	public List<Integer> diffWaysToCompute(String input) {
		int len = input.length();
		List<Integer> res = new LinkedList<Integer>();
		if (len == 0) {
			return res;
		}
		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1Res = diffWaysToCompute(part1);
				List<Integer> part2Res = diffWaysToCompute(part2);
				for (int p1 : part1Res) {
					for (int p2 : part2Res) {
						int tmp = 0;
						switch (ch) {
						case '+':
							tmp = p1 + p2;
							break;
						case '-':
							tmp = p1 - p2;
							break;
						case '*':
							tmp = p1 * p2;
							break;
						}
						res.add(tmp);
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}
	
	public static void main(String[] args) {
		DifferentWaystoAddParentheses sol = new DifferentWaystoAddParentheses();
		String input = "11-1";
		System.out.println(sol.diffWaysToCompute(input));
	}
}