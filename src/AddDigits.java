public class AddDigits {
	public int addDigits(int num) {
		return num - 9 * ((num - 1) / 9);
	}
	
	public static void main(String[] args) {
		AddDigits sol = new AddDigits();
		for (int i = 0; i < 30; i++) {
			System.out.print(sol.addDigits(i) + " ");
		}
	}
}