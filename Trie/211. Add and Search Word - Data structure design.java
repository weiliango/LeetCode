class TriNode {
    boolean isWord;
    TriNode[] children = new TriNode[26];
}

public class WordDictionary {
    TriNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TriNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TriNode ws = root;
        for(char ch: word.toCharArray()) {
            if(ws.children[ch-'a'] == null)
                ws.children[ch-'a'] = new TriNode();
            ws = ws.children[ch-'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }
    
    public boolean helper(char[] words, int idx, TriNode root) {
        if(idx == words.length) return root.isWord;
        if(words[idx] != '.') {
            if(root.children[words[idx]-'a'] == null ) return false;
            return helper(words, idx+1, root.children[words[idx]-'a']);
        } else {
            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null)
                    if(helper(words, idx+1, root.children[i]))
                        return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */