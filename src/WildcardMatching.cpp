class Solution {
public:
	// Time:O(m * n) Space:O(1)
    bool isMatch(const char *s, const char *p) {
      bool star = false;
      const char *str, *ptr;
      for(str = s, ptr = p; *str !='\0'; str++, ptr++) {
          switch (*ptr) {
          case '?':
              break;
          case '*':
              star = true;
              s = str; p = ptr;
              while (*p == '*') p++; // skip continue *.
              if (*p == '\0') return true;
              str = s - 1;
              ptr = p - 1;
              break;
          default:
              if (*str != *ptr) {
                  if (!star) return false;
                  s++;
                  str = s - 1;
                  ptr = p - 1;
              }
          }
      }
      while (*ptr == '*') ptr++;
      return *ptr == '\0';
    }
};