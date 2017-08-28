class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        backtrack(res, "", n, 0, 0);
        return res;
    }
    public void backtrack(List<String> res, String s, int n, int open, int close) {
        if(s.length() == n * 2) {
            res.add(s);
            return;
        }
        if(open < n)
            backtrack(res, s + '(', n, open + 1, close);
        if(close < open)
            backtrack(res, s + ')', n, open, close + 1);
    }
}