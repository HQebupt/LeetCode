// Time: O(m * n) Space: O(1)
// Better Solution: KMP, Boyer-Mooer,Rabin-Karp算法
// 最好自己能够实现这个暴力的解法
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    
    public static void main(String[] args) {
    	ImplementStrStr sol = new ImplementStrStr();
    	String haystack = "solution";
    	String needle = "ol";
    	int result = sol.strStr(haystack, needle);
    	System.out.println(result);
    }
}