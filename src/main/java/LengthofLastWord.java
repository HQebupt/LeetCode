public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		String[] words = s.split("\\s");
		int length = words.length;
		length = (length == 0) ? 0 : words[length - 1].length();
		return length;
	}
}