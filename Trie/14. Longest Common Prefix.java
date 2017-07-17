class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int children_count = 0;
}
public class Solution {
    TrieNode root;
    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();
        int min_length = Integer.MAX_VALUE;
        for(String str: strs) {
            str = str.toLowerCase();
            min_length = Math.min(min_length, str.length());
            TrieNode curr = root;
            for(char ch: str.toCharArray()) {
                if(curr.children[ch-'a'] == null) {
                    curr.children[ch-'a'] = new TrieNode();
                    curr.children_count += 1;
                }
                curr = curr.children[ch-'a'];
            }
        }
        StringBuilder res = new StringBuilder();
        while(res.length() < min_length) {
            if(root.children_count == 1) {
                for(int i = 0; i < 26; i++) {
                    if(root.children[i] != null) {
                        res.append((char)(i+'a'));
                        root = root.children[i];
                        break; // need this break, because root is changed
                    }
                }
            } else {
                break;
            }
        }
        return res.toString();
    }
}