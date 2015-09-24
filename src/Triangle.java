import java.util.ArrayList;
import java.util.List;

public class Triangle {
	// 一维DP
	// 从上往下想
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		if (size == 0)
			return 0;
		int[] sum = new int[size];
		sum[0] = triangle.get(0).get(0);
		for (int i = 1; i < size; i++) {
			int level = i;
			sum[i] = sum[i - 1] + triangle.get(i).get(i);
			for (int j = level - 1; j >= 1; j--) {
				sum[j] = Math.min(sum[j - 1], sum[j]) + triangle.get(i).get(j);
			}
			sum[0] = sum[0] + triangle.get(i).get(0);
		}

		// 遍历sum，求最小值
		int min = Integer.MAX_VALUE;
		for (int s : sum) {
			min = Math.min(s, min);
		}
		return min;
	}

	// 从下往上想
	public int minimumTotal1(List<List<Integer>> triangle) {
		int size = triangle.size();
		if (size == 0)
			return 0;
		int[] sum = new int[size];
		for (int i = 0; i < size; i++) {
			sum[i] = triangle.get(size - 1).get(i);
		}
		for (int i = size - 2; i >= 0; i--) {
			int level = i;
			for (int j = 0; j <= level; j++) {
				sum[j] = Math.min(sum[j], sum[j + 1]) + triangle.get(i).get(j);
			}
		}
		return sum[0];
	}

	public static void main(String[] args) {
		Triangle sol = new Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>(4);
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);

		int res = sol.minimumTotal1(triangle);
		System.out.println(res);
	}
}