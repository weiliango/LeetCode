class Solution {
    public int repeatedStringMatch(String A, String B) {
        int i = 0;
        int j = 0;
        int[] lps = computeLPSArray(B);
        int n = 1;
        while (n == 1 || A.length() * n / B.length() < 3) {
            while (i < A.length()) {
                if(A.charAt(i) == B.charAt(j)) {
                    i++;
                    j++;
                    if(j == B.length())
                        return n;
                } else {
                    if (j != 0)
                        j = lps[j-1];
                    else
                        i++;
                }
            }
            i = 0;
            n++;
        }
        return -1;
    }
    private int[] computeLPSArray(String str) {
        int len = 0;
        int i = 1;
        int n = str.length();
        int[] lps = new int[n];
        while (i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0)
                    len = lps[len-1];
                else
                    i++;
            }
        }
        return lps;
    }
}