public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strings) {
            char[] chs = str.toCharArray();
            String key = getKey(chs);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(List<String> v : map.values()) {
            res.add(v);
        }
        return res;
    }
    private String getKey(char[] chs) {
        for(int i = chs.length - 1; i >= 0; i--) {
            if(chs[i] < chs[0])
                chs[i] += 26;
            chs[i] -= chs[0];
        }
        return new String(chs);
    }
}