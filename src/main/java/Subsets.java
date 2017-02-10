import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//时间复杂度：O(nlogn+2^n) 空间复杂度:O(n)
public class Subsets {
	public List<ArrayList<Integer>> subsets(int[] S) {
		int length = S.length;
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < length; i++) {
			ArrayList<ArrayList<Integer>> tmpList = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> l : res) {
				int len = l.size();
				l.add(len, S[i]);
				ArrayList<Integer> tmp = new ArrayList<Integer>(l);
				tmpList.add(tmp);
				l.remove(len);
			}
			res.addAll(tmpList);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] S = { 1, 1, 0 };
		Subsets sol = new Subsets();
		System.out.println(sol.subsets(S));

	}
}