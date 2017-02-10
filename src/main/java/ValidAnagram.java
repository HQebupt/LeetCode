import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	/**
	 * HashMap思路
	 */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) 
        	return false;
        for (int i = 0; i < slen; i++) {
        	Character c = s.charAt(i);
        	if (smap.containsKey(c)) {
        		int count = smap.get(c);
        		count++;
        		smap.put(c, count);
        	} else {
        		smap.put(c,1);
        	}
        }
        
        for (int i = 0; i < tlen; i++) {
        	Character c = t.charAt(i);
        	if (smap.containsKey(c)) {
        		int count = smap.get(c);
        		count--;
        		if(count == 0) {
        			smap.remove(c);
        		} else {
        			smap.put(c, count);
        		}
        	} else {
        		return false;
        	}
        }
        return smap.isEmpty();
    }
    
    public static void main(String[] args) {
    	ValidAnagram sol = new ValidAnagram();
    	String s = "anagram", t = "nagaram";
    	boolean res = sol.isAnagram(s, t);
    	System.out.println(res);
    }
}