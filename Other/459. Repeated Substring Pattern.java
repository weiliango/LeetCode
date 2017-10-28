class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int len = 0;
        int i = 1;
        int[] lps = new int[n];
        while (i < n) {
            if(s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0)
                    i++;
                else {
                    len = lps[len-1];
                }
            }
        }
        String pat = s.substring(0, s.length() - lps[n-1]);
        int p = 0, q = 0;
        while(p < n) {
            if(s.charAt(p) == pat.charAt(q)) {
                p++;
                q++;
                if(q == pat.length())
                    q = 0;
            } else {
                return false;
            }
        }
        return lps[n-1] != 0 && n % (n - lps[n-1]) == 0;
    }
}