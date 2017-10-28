class Solution {
    public String reverseWords(String s) {
        int prev = -1;
        char[] chs = s.toCharArray();
        for(int i = 1; i <= chs.length; i++) {
            if(i == chs.length || chs[i] == ' ') {
                reverse(chs, prev + 1, i - 1);
                prev = i;
            }
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