public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);

            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<String>());
                map.get(key).add(str);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}