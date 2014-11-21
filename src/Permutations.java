import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutations {
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		returnList.add(new ArrayList<Integer>());
		for (int i = 0; i < len; i++) {
			ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> res : returnList) {
				int size = res.size();
				for (int j = 0; j < size + 1; j++) {
					res.add(j, num[i]);
					ArrayList<Integer> tmp = new ArrayList<Integer>(res);
					set.add(tmp);
					res.remove(j);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(set);
		}
		return returnList;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		Permutations sol = new Permutations();
		System.out.println(sol.permute(num));
	}
}
