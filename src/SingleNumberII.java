public class SingleNumberII {
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
}
/**
 * As for bit operation, I do not know well. I need to redo it again and make out.
 * Solution Report:http://blog.csdn.net/lanxu_yy/article/details/17437891
 * http://www.tuicool.com/articles/UjQV7n
 * http://blog.csdn.net/jiadebin890724/article/details/23306837
 */ 