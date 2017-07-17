class TriNode{
    boolean isWord = false;
    TriNode[] children = new TriNode[26];
}
public class Solution {
    TriNode root;
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new LinkedList<List<String>>();
        root = new TriNode();
        for(String word: words) {
            TriNode curr = root;
            for(char ch: word.toCharArray()) {
                if(curr.children[ch] == null)
                    curr.children[ch] = new TriNode();
                curr = curr.children[ch];
            }
            curr.isWord = true;
        }
        return res;
    }
    public void backtrack(List<List<String>> res, List<String> list, StringBuilder prefix) {
        
    }
}