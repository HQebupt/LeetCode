public class SearchinRotatedSortedArrayII {
	// Binary Search
	// Time: O(logn)最坏情况下是 O(n)    Space: O(1)
    public boolean search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while (low <= high) {
        	mid = (low + high) >> 1;
        	if (target == A[mid])
        		return true;
        	else {
        		if(A[mid] < A[high]) { //右半段有序
        			if (target > A[mid] && target <= A[high])
        				low = mid + 1;
        			else
        				high = mid - 1;
        				
        		} else if (A[mid] > A[high]){ //左半段有序
        			if (target < A[mid] && target >= A[low])
        				high = mid - 1;
        			else
        				low = mid + 1;
        		} else // 无法判断哪段有序，只能够移动一步。
        			high--;
        	}
        }
        return false;
    }
    // reference:
    // http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array_3.html
    // http://blog.csdn.net/linhuanmars/article/details/20588511
    
    // Solution 2: O(n)的复杂度也是可以过的。
    public boolean search2(int[] A, int target) {
    	boolean found = false;
    	for (int i = 0; i < A.length; i++) {
    		if(target == A[i]) {
    			found = true;
    			break;
    		}
    	}
    	return found;
    }
}