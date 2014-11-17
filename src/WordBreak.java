import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreakHelper(String s, Set<String> dict,
			Set<String> unmatch) {
		int len = s.length();
		if (len < 1)
			return true;
		boolean flag = false;
		for (int i = 1; i <= len; i++) {
			String prefixStr = s.substring(0, i);
			if (dict.contains(prefixStr)) {
				String suffixStr = s.substring(i);
				if (unmatch.contains(suffixStr)) {
					continue;
				} else {
					flag = wordBreakHelper(suffixStr, dict, unmatch);
					if (flag)
						return true;
					else{
						unmatch.add(suffixStr);
					}
				}
			}
		}
		return false;
	}

	public boolean wordBreak(String s,Set<String> dict){
		int len = s.length();
		if(len < 1) return true;
		Set<String> unmatch = new HashSet<String>();
		return wordBreakHelper(s, dict, unmatch);
	}
}
/**
 * Attentino:I know DP little. And this subject I dont make it out.
 * Solution Report Reference:http://blog.csdn.net/doc_sgl/article/details/12323015
 */ 