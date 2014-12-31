import java.util.LinkedList;

// Time: O(n)  Space: O(n)
public class EvaluateReversePolishNotation  {
	public int evalRPN(String[] tokens) {
		LinkedList<Integer> ls = new LinkedList<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			char ch = tokens[i].charAt(0);
			int size = tokens[i].length();
			if ((size > 1) || Character.isDigit(ch)) {
				ls.add(Integer.valueOf(tokens[i]));
			} else {
				int sec = ls.pollLast();
				int fir = ls.pollLast();
				ls.addLast(evalNum(sec, fir, ch));
				// System.out.println("fir:" + fir + " sec:" + sec + " res:"
				// + ls.peek());
			}
		}
		return ls.poll();
	}

	private int evalNum(int sec, int fir, char ch) {
		int res = 0;
		switch (ch) {
		case '+':
			res = fir + sec;
			break;
		case '-':
			res = fir - sec;
			break;
		case '*':
			res = fir * sec;
			break;
		case '/':
			res = fir / sec;
			break;
		default:
			break;
		}
		return res;
	}
}
/**
 * Reverse Polish Notation solution is stack. Traverse the String[] tokens, if tokens[i] is num, push it to the stack;if not num,that means it is an operator. then poll two nums ,and calculate them. put the result to the stack. At end,the stack has only one num,that's the solution.
 * In java,LinkedList is primary use to Stack(java 1.0).
 * <Thinking in Java> says,you should use LinkedList instead of Stack. and the LinkedList's method is this.pollLast() and this.addLast().
 *Attention:number like "-1""+2" should be considered. we can use the tokens's length.(if length > 1,the tokens must be number.) 
 * for more information: see blog:http://blog.csdn.net/xiaoniba1024/article/details/6575523
 */