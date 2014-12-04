import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	//Time:O(n) Space:0(n)
	public int ladderLength(String start, String end, Set<String> dict) {
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		wordQueue.add(start);
		distanceQueue.add(1);
		dict.add(end);

		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			int currDistance = distanceQueue.pop();
			if (currWord.equals(end)) {
				return currDistance;
			}

			int len = currWord.length();
			for (int i = 0; i < len; i++) {
				char[] currChar = currWord.toCharArray();
				for (char c = 'a'; c < 'z'; c++) {
					currChar[i] = c;
					String newWord = new String(currChar);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		WordLadder sol = new WordLadder();
		String start = "hit", end = "coh";
		HashSet<String> dict = new HashSet<String>();
		String[] d = { "hot", "dot", "dog", "lot", "log" };
		for (String s : d) {
			dict.add(s);
		}
		System.out.println("res:" + sol.ladderLength(start, end, dict));

		/**
		 * test the LinkedList add and pop method.
		 */
		// LinkedList<String> wordQueue = new LinkedList<String>();
		// wordQueue.add("1");
		// wordQueue.add("2");
		// wordQueue.pop();
		// System.out.println(wordQueue);

	}
}