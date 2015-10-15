public class NimGame {
	public boolean canWinNim(int n) {
		return (n % 4) == 0 ? false : true;
	}
	
	public static void main(String[] args) {
		NimGame sol = new NimGame();
		int n = 1;
		System.out.println(sol.canWinNim(n));
	}
}