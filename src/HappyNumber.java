import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
        Set<Integer> pool = new HashSet<Integer>();
        while (true)  {
        	n = happy(n);
        	if (n == 1) {
        		return true;
        	}
        	if (pool.contains(n)) {
        		return false;
        	} else {
        		pool.add(n);
        	}
        }
    }

	private int happy(int n) {
		int count = 0; 
		while (n != 0) {
			int m = n % 10;
			n = n / 10;
			count += m * m;
		}
		return count;
	}
	
	public static void main(String[] args) {
		HappyNumber sol = new HappyNumber();
		System.out.println(sol.isHappy(19));
	}
}