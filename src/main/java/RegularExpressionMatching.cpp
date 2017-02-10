class Solution {
// Time:O(n) Space:O(1)
public:
    bool isMatch(const char *s, const char *p) {
        if (*p == '\0') return *s == '\0';
        
        // next char is not '*',then must match
        if (*(p+ 1) != '*') {
            if (*p == *s || (*p == '.' && *s != '\0'))
                return isMatch(s + 1, p + 1);
            else
                return false;
        } else { // next char is '*'
            while(*p == *s || (*p == '.' && *s != '\0')) {
                if (isMatch(s, p + 2))
                    return true;
                s++;
            }
            return isMatch(s, p + 2);
        }
    }
};