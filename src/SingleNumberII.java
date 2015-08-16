public class SingleNumberII {
	// Solution 0:
	// 这个题比较直接的想法是用一个HashMap对于出现的元素进行统计，key是元素，value是出现个数，
	// 如果元素出现三次，则从HashMap中移除，最后在HashMap剩下来的元素就是我们要求的元素（因为其他元素都出现三次，有且仅有一个元素不是如此）。
	// 这样需要对数组进行一次扫描，所以时间复杂度是O(n)，而需要一个哈希表来统计元素数量，总共有(n+2)/3个元素，
	// 所以空间复杂度是O((n+2)/3)=O(n)。这个方法非常容易实现，就不列举代码了。

	// Solution 1:掩码变量
	// Time:O(n)  Space:O(1)
    public int singleNumber(int A[]) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < A.length; i++) {
			threes = twos & A[i];
			twos |= ones & A[i];
			ones |= A[i];

			twos &= ~threes;
			ones &= ~threes;
		}
		return ones;
	}
    
    // Solution 2:
    // Time:O(n*32)  Space:O(1)
    public int singleNumber1(int[] A) {
    	int res = 0;
    	int[] count32 = new int[32];
    	for (int i = 0; i < 32; i++) {
    		for (int j = 0; j < A.length; j++) {
    			count32[i] += ((A[j] >> i) & 1);
    		}
    		res += (count32[i] % 3) << i;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	SingleNumberII sol = new SingleNumberII();
    	int[] A = {1,1,1,2,2,2,10};
    	System.out.println(sol.singleNumber1(A));
    	
    }
}
/**
 * As for bit operation, I do not know well. I need to redo it again and make out.
 * Reference:http://www.acmerblog.com/leetcode-single-number-ii-5394.html
 * Solution Report:http://blog.csdn.net/lanxu_yy/article/details/17437891
 * http://www.tuicool.com/articles/UjQV7n
 * http://blog.csdn.net/jiadebin890724/article/details/23306837
 */ 