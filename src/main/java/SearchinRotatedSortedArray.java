public class SearchinRotatedSortedArray {
	// Binary Search
	// 用例子来探索，什么样的数会落在哪一个半边？
	// Time: O(logn)  Space: O(1)
    public int search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while (low <= high) {
        	mid = (low + high) >> 1;
        	if (target == A[mid])
        		return mid;
        	else {
        		if(A[mid] < A[high]) { //右半段有序
        			if (target > A[mid] && target <= A[high])
        				low = mid + 1;
        			else
        				high = mid - 1;
        				
        		} else { //左半段有序
        			if (target < A[mid] && target >= A[low])
        				high = mid - 1;
        			else
        				low = mid + 1;
        		}
        	}
        }
        return -1;
    }
    // reference: http://blog.csdn.net/linhuanmars/article/details/20525681
}