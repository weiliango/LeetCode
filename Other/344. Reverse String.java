class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int p = 0, q = c.length-1;
        while(p < q) {
            c[p] ^= c[q];
            c[q] ^= c[p];
            c[p] ^= c[q];
            p++;
            q--;
        }
        return new String(c);
    }
}