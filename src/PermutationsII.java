import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> tmpSet = new HashSet<ArrayList<Integer>>();
			for (ArrayList<Integer> res : returnList) {
				int size = res.size();
				for (int j = 0; j < size + 1; j++) {
					res.add(j, num[i]);
					ArrayList<Integer> tmp = new ArrayList<Integer>(res);
					tmpSet.add(tmp);
					res.remove(j);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(tmpSet);
		}
		return returnList;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		PermutationsII sol = new PermutationsII();
		System.out.println(sol.permuteUnique(num));
	}

}
