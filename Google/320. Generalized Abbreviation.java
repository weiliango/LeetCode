class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<String>();
        backtrack(res, word, 0);
        res.add(word);
        // Collections.sort(res);
        return res;
    }
    private void backtrack(List<String> res, String sb, int start) {
        for(int i = start; i < sb.length(); i++) {
            for(int step = 1; i + step <= sb.length(); step++) {
                String candidate = sb.substring(0, i) + step + sb.substring(i + step, sb.length());
                // if(!res.contains(candidate)) res.add(candidate);
                res.add(candidate);
                backtrack(res, candidate, i + 1 + digitsNum(step));
            }
        }
    }
    private int digitsNum(int step) {
        int ret = 0;
        while(step > 0) {
            ret++;
            step /= 10;
        }
        return ret;
    }
}