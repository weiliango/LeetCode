class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] lps = computeLPSArray(needle);
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length())
                    return i - j;
            } else {
                if (j != 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
        return -1;
    }
    public int[] computeLPSArray(String s) {
        int[] lps = new int[s.length()];
        int i = 1;
        int len = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len-1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}