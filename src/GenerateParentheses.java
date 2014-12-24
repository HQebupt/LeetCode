import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
		String s = "";
		dfs(n, 0, 0, s, result);
		return result;
    }
    // Time:O(n!) Space:O(n)
    private void dfs(int n, int left, int right, String intermediate, List<String> result) {
    	if ( left == n && right == n) {
    		String ans = intermediate.toString();
    		result.add(ans);
    		return;
    	}
    	if ( left > n || right > n) 
    		return;
    	if (left < n) 
    		dfs(n, left + 1, right, intermediate + "(", result);
    	if (left - right > 0)
    		dfs(n, left, right + 1, intermediate + ")", result);
    }
    public static void main(String[] args) {
    	GenerateParentheses sol = new GenerateParentheses();
    	int n = 3;
    	List<String> res = sol.generateParenthesis(n);
		System.out.println(res);
	}
}