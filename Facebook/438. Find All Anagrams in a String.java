class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256];
        for(char c: p.toCharArray()) hash[c]++;
        int left = 0;
        int right = 0;
        int counter = p.length();
        while(right < s.length()) {
            if(hash[s.charAt(right++)]-- >= 1) counter--;
            if(counter == 0) list.add(left);
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) counter++;
        }
        return list;
    }
}