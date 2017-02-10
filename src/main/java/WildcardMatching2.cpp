class Solution {
// Time:O(n! * m!) Space:O(1)
// Time Limit Exceeded
public:
    bool isMatch(const char *s, const char *p) {
        if (*p == '\0') return *s == '\0';
        
        // current char is not '*',then must match
        if (*p != '*') {
            if (*p == *s || (*p == '?' && *s != '\0'))
                return isMatch(s + 1, p + 1);
            else
                return false;
        } else { // next char is '*'
        	while(*p == '*')
        		p++;
        	if(*p == '\0') return true;
        	while(*s != '\0' && !isMatch(s,p)){
        	    s++;
        	}
        	return *s != '\0';
        }
    }
};


int main(){
        Solution* sol = Solution();
        char* s = "aab";
        char* p = "a*a*b*";
        cout<<sol->isMatch(s, p);
}