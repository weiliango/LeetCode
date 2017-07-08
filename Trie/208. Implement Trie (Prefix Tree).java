class TrieNode {
    boolean isWord = false;
    TrieNode[] children = new TrieNode[26];
}
public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root; //words
        for(char ch: word.toCharArray()) {
            if(ws.children[ch - 'a'] == null)
                ws.children[ch - 'a'] = new TrieNode();
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for(char ch: word.toCharArray()) {
            if(ws.children[ch - 'a'] == null) return false;
            ws = ws.children[ch - 'a'];
        }
        return ws.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(char ch: prefix.toCharArray()) {
            if(ws.children[ch - 'a'] == null) return false;
            ws = ws.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */