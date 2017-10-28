class Solution {
    HashMap<Character, Character> map;
    public List<String> findStrobogrammatic(int n) {
        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        List<String> res = new ArrayList<>();
        backtrack(n, new StringBuilder(), res, 0);
        return res;
    }
    private void backtrack(int n, StringBuilder cand, List<String> res, int idx) {
        if (n == 0) {
            if(cand.length() > 1 && cand.charAt(0) == '0')
                return;
            res.add(cand.toString());
            return;
        }
        if (n == 1) {
            for (char key: map.keySet()) {
                if (key == map.get(key)) {
                    cand.insert(idx, key);
                    backtrack(n-1, cand, res, idx+1);
                    cand.deleteCharAt(idx);
                }
            }
            return;
        }
        for (char key: map.keySet()) {
            cand.insert(0, key);
            cand.append(map.get(key));
            backtrack(n - 2, cand, res, idx + 1);
            cand.deleteCharAt(0);
            cand.deleteCharAt(cand.length() - 1);
        }
    }
}