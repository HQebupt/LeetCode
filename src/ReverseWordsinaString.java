public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int size = words.length - 1;
		String res = words[size];
		for (int i = size -1; i >= 0; i--) {
				res = res + " " + words[i];
		}
		return res;
    }
}
/**
 * use split() method,clean up redundancy like "",and then reverse the words.
 * advanced point:regular expression "\\s+" can clean up redundancy blank.
 * attention:if input is "    ", the expect output is "". and the code is ok because of split("\\s+").
 */