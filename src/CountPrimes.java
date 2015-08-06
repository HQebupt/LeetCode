public class CountPrimes {
	// 判断一个数是否是素数的方法：不是最好，但还可以。素数表是判断素数的好方法。
	// Time:O(sqrt(n)) Space:O(1)
	boolean isPrime(int n) {
		for (int i = 2; (i * i) <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Solution 1: 逐个判断是否是素数，思路简单。但是超时
	 * Time:O(n^1.5) Space:O(1)
	 */
	public int countPrimes1(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if(isPrime(i))  count++;
		}
		return count;
	}
	
	/**
	 * Solution 2: 素数表的做法
	 * 思路：本题是计算素数的个数。那么，在`[1 to n)`的范围内，标记出 非素数，剩下的就是素数了。
	 * 如何标记 非素数呢？分组标记：2,[4,6,8,10,12,14,16,18,20,22,24...]; 3,[9,12,15,18,21,24,27,...]; 5,[25,30,35...]
	 * 
	 * 记住：0，1既不是素数也不是合数。
	 * Time: O(n log log n) Space: O(n)
	 */
	public int countPrimes(int n) {
		// 初始化所有的都是素数，在剔除掉 `非素数`
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		
		// 剔除非素数
		for (int i = 2; (i * i) < n; i++){
			if (isPrime[i]) {
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		// 统计素数个数
		int count = 0;
		for (boolean is : isPrime) {
			if (is) count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		CountPrimes sol = new CountPrimes();
		int n = 10;
		System.out.println(n + ":" + sol.countPrimes(n));
		System.out.println(n + ":" + sol.countPrimes1(n));
	}

}
