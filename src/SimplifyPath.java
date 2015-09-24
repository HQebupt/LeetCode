import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
	// stack思想
	public String simplifyPath(String path) {
		String[] words = path.split("/");
		Deque<String> stack = new LinkedList<String>();
		for (String word : words) {
			if (word.equals("..")) {
				if (!stack.isEmpty())
					stack.removeLast();
			} else if (!(word.length() == 0 || word.equals("."))) {
				stack.addLast(word);
			}
		}
		String res = "";
		for (String s : stack) {
			res += "/" + s;
		}
		return res.equals("") ? "/" : res;
	}

	public static void main(String[] args) {
		SimplifyPath sol = new SimplifyPath();
		String path = "/../";
		System.out.println(sol.simplifyPath(path));
	}
}
