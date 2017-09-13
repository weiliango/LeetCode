class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0) return true;
        if(s2 == null || s2.length() == 0) return false;
        int[] hash = new int[256];
        for(char ch: s1.toCharArray()) hash[ch]++;
        int left = 0;
        int right = 0;
        int counter = s1.length();
        while(right < s2.length()) {
            if(hash[s2.charAt(right++)]-- >= 1) counter--;
            if(counter == 0) return true;
            if(right - left == s1.length() && hash[s2.charAt(left++)]++ >= 0) counter++;
        }
        return false;
    }
}