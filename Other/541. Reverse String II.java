class Solution {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i += k*2) {
            reverse(chs, i, Math.min(i+k-1, chs.length-1));
        }
        return new String(chs);
    }
    private void reverse(char[] chs, int start, int end) {
        while(start < end) {
            chs[start] ^= chs[end];
            chs[end] ^= chs[start];
            chs[start] ^= chs[end];
            start++;
            end--;
        }
    }
}