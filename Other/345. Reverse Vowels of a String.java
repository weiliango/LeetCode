class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int p = 0, q = chs.length - 1;
        while (p < q) {
            if(vowels.indexOf(chs[p] + "") == -1)
                p++;
            if(vowels.indexOf(chs[q] + "") == -1)
                q--;
            if(vowels.indexOf(chs[p] + "") != -1 && vowels.indexOf(chs[q] + "") != -1 && p != q) {
                chs[p] ^= chs[q];
                chs[q] ^= chs[p];
                chs[p] ^= chs[q];
                p++;
                q--;
            }
        }
        return new String(chs);
    }
}