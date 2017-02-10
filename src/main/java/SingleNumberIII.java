import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumberIII {
	/**
	 * 自己想的一个方法：让数组中每一个元素local，在不包含自己的时候，求出一个整体异或的值。
	 * 对于用例{1,2,1,3,2,5}, 如果不包含3的情况下，就一定可以把5找出来；
	 * 对于出现两次的数，如果不包含1的情况下，会有两个结果，用set将它remove掉，最后剩下的就是出现一次的数。
	 */
	public int[] singleNumber0(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int res = 0;
		for (int num : nums) {
			res = res ^ num;
		}

		for (int num : nums) {
			Integer local = res ^ num;
			if (set.contains(local)) {
				set.remove(local);
			} else {
				set.add(local);
			}
		}
		int[] single = new int[2];
		int i = 0;
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			single[i] = it.next();
			i++;
		}
		return single;
	}

	// 更加fashion的做法
	public int[] singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res = res ^ num;
		}

		// 寻找某一位是1的数字。
		int index1 = 0;
		for (int i = 0; i < 32; i++) {
			int tmp = (res >> i) & 1;
			if (tmp == 1) {
				index1 = i;
				break;
			}
		}
		
		// 用这个1将数组分成两段，分别求出出现一次的数，最后可以求出结果。
		int firstRes = 0, secondRes = 0;
		for (int num : nums) {
			if (isIndex1(num, index1)) {
				firstRes ^= num;
			} else {
				secondRes ^= num;
			}
		}
		
		int[] resArray = new int[2];
		resArray[0] = firstRes;
		resArray[1] = secondRes;
		return resArray;

	}

	private boolean isIndex1(int num, int index) {
		int tmp = (num >> index) & 1;
		return tmp == 1 ? true : false;
	}

	public static void main(String[] args) {
		SingleNumberIII sol = new SingleNumberIII();
		int[] nums = { 1, 2, 1, 3, 2, 5, 4, 4 };
		int[] res = sol.singleNumber(nums);
		System.out.println(Arrays.toString(res));
	}
}
