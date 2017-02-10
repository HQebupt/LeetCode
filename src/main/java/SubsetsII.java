import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//时间复杂度：O(nlogn+2^n) 空间复杂度:O(n)
public class SubsetsII {
	public List<ArrayList<Integer>> subsetsWithDup(int[] num) {
		int length = num.length;
		Arrays.sort(num);
		Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < length; i++) {
			Set<ArrayList<Integer>> tmpList = new HashSet<ArrayList<Integer>>();
			for (ArrayList<Integer> l : res) {
				int len = l.size();
				l.add(len, num[i]);
				ArrayList<Integer> tmp = new ArrayList<Integer>(l);
				tmpList.add(tmp);
				l.remove(len);
			}
			res.addAll(tmpList);
		}
		return new ArrayList<ArrayList<Integer>>(res);
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 0 };
		SubsetsII sol = new SubsetsII();
		System.out.println(sol.subsetsWithDup(num));

	}
}