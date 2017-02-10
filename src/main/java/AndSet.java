import java.util.ArrayList;
import java.util.List;

/**
 * User: huangqiang
 * Date: 11/10/15
 * Time: 7:16 PM
 */
public class AndSet {

    /**
     * N个有序集合求交集
     * @param marr 数组1
     * @param narr 数组2
     * @return 两个数组的交集
     * Time:O(m + n)  Space:O(1)
     */
    public List<Integer> innerSet(int[] marr, int[] narr) {
        int len1 = marr.length;
        int len2 = narr.length;
        List<Integer> res = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        while ((p1 < len1) && (p2 < len2)) {
            if (marr[p1] == narr[p2]) {
                res.add(marr[p1]);
                p1++;
                p2++;
            } else if (marr[p1] < narr[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AndSet sol = new AndSet();
        int[] arr1 = {1, 2, 3, 5, 7, 8};
        int[] arr2 = {2, 3, 4, 6, 7, 9};
        System.out.println(sol.innerSet(arr1, arr2));
    }
}
