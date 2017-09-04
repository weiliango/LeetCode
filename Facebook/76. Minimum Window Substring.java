class Solution {
    public String minWindow(String s, String t) {
        //preprocessing
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()) {
            if(!map.containsKey(ch))
                map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        // processing
        char[] chs = s.toCharArray();
        String ret = s + "a";
        int start = -1;
        int counter = 0;
        for(int i = 0; i < chs.length; i++) {
            if(map.containsKey(chs[i])) {
                counter++;
                map.put(chs[i], map.get(chs[i]) - 1);
                if(map.get(chs[i]) < 0) {
                    for(int j = start + 1; j < i; j++) {
                        if(map.containsKey(chs[j])) {
                            if(map.get(chs[j]) == 0)
                                break;
                            map.put(chs[j], map.get(chs[j]) + 1);
                            counter--;
                        }
                        start++;
                    }
                }
                if(counter == t.length() && isValid(map)) {
                    String candidate = s.substring(start+1, i+1);
                    if(candidate.length() < ret.length())
                        ret = candidate;
                }
            }
        }
        if(ret.length() > s.length())
            return "";
        return ret;
    }
    private boolean isValid(HashMap<Character, Integer> map) {
        for(char key: map.keySet()) {
            if(map.get(key) > 0)
                return false;
        }
        return true;
    }
}