import java.util.LinkedList;

// Sol 1: Stack. Time:O(n) Space:O(n)
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int len = height.length;
		int[] heightNew = new int[len + 1];
		for (int i = 0; i < len; i++) {
			heightNew[i] = height[i];
		}
		heightNew[len] = 0;
		int result = 0;
		for (int i = 0; i < heightNew.length;) {
			if (stack.isEmpty() || heightNew[stack.peek()] < heightNew[i]) {
				stack.push(i);
				i++;
			} else {
				int tmp = stack.pop();
				int count = stack.isEmpty() ? i : i - stack.peek() - 1;
				result = max(result, heightNew[tmp] * count);
			}
		}
		return result;
	}

	private int max(int m, int n) {
		return m > n ? m : n;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
		int[] height = { 2, 1, 5, 6, 3 };
		System.out.println(sol.largestRectangleArea(height));
	}
}