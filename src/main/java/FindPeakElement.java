// Time:O(log n) Space:O(1)
public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num == null)
			return -1;
		if (num.length <= 1)
			return 0;
		int low = 0;
		int high = num.length - 1;
		int mid = (low + high) / 2;
		while (low <= high && !peekMax(mid, num)) {
			if (up(mid, num)) {
				low = mid + 1;
				mid = (low + high) / 2;
			} else {
				high = mid - 1;
				mid = (low + high) / 2;
			}
		}
		return mid;
	}

	private boolean up(int mid, int[] num) {
		if (mid == 0)
			return num[mid] < num[mid + 1] ? true : false;
		return num[mid] > num[mid - 1] ? true : false;
	}

	private boolean peekMax(int mid, int[] num) {
		if (mid == 0) {
			return num[mid] > num[mid + 1] ? true : false;
		}
		if (mid == num.length - 1)
			return num[mid] > num[mid - 1] ? true : false;
		return num[mid] > num[mid + 1] && num[mid] > num[mid - 1] ? true : false;
	}

	public static void main(String[] args) {
		int[] num = { 3, 2, 1 };
		FindPeakElement sol = new FindPeakElement();
		int res = sol.findPeakElement(num);
		System.out.println(res);
	}
}