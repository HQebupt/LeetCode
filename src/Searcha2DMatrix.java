public class Searcha2DMatrix {
	// 二分查找
	// Solution 1: 将二维矩阵延展成一维数组
	/**
	 * position: 0   1   2   3   4   5   6   7   8   9   10   11   
	   values:   1   3   5   7   10  11  16  20  23  30  34   50
	   row:      0   0   0   0   1   1   1   1   2   2    2    2
	   column:   0   1   2   3   0   1   2   3   0   1    2    3 
	          行数rows=3，列数columns=4
	 */
	// Time: O(logn)  Space:O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0)
    		return false;
    	int rows = matrix.length;
    	int columns = matrix[0].length;
        int low = 0;
        int high = rows * columns - 1;
        while (low <= high) {
        	int mid = (low + high) >> 1;
        	int r = mid / columns;
        	int c = mid % columns;
        	if (target == matrix[r][c])
        		return true;
        	else if (target > matrix[r][c])
        		low = mid + 1;
        	else 
        		high = mid - 1;
        }
        return false;
    }
    
    // Solution 2: 直接在矩阵中二分查找
    
    // Refer:http://www.cnblogs.com/springfor/p/3857959.html
    // http://blog.csdn.net/linhuanmars/article/details/24216235
}