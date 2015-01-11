import java.util.LinkedList;
import java.util.List;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] words = path.split("/");
		List<String> stack = new LinkedList<String>();
		for (String s : words) {
			if (s.equalsIgnoreCase("..")) {
				if (!stack.isEmpty())
					stack.remove(stack.size() - 1);
			} else if (!(s.length() == 0 || s.equalsIgnoreCase("."))) {
				stack.add(s);
			}
		}
		String res = "";
		for (String s : stack) {
			res += "/" + s;
		}
		return res.length() == 0 ? "/" : res;
	}

	public static void main(String[] args) {
		SimplifyPath sol = new SimplifyPath();
		String path = "/a/./b/../../c/";
		System.out.println(sol.simplifyPath(path));
	}
}
