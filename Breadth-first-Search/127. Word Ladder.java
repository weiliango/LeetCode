public class Solution {
	Queue<String> q = new LinkedList<String>();
	Stack<String> stack = new Stack<String>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() == 1) return 2;
        return bfs(beginWord, endWord, wordList);
    }
    public int bfs(String beginWord, String endWord, List<String> wordList) {
    	int round = 1;
    	int size = 0;
    	int max_round = wordList.size() + 1;

    	q.add(beginWord);
    	size = q.size();
    	wordList.remove(beginWord);

    	while(!q.isEmpty()) {
    		String curr = q.poll();
    		//System.out.println(curr);
    		//System.out.println(round);
    		if ( curr.equals(endWord) ) {
    			return round;
    		}
    		for ( String s: wordList){
    			if ( compare(curr, s) ) {
    				q.add(s);
    				stack.push(s);
    			}
    		}
    		while( !stack.isEmpty() ) {
				wordList.remove(stack.pop());
    		}

    		if ( --size == 0 ) {
    		    //System.out.println(q.size());
    			size = q.size();
    			round++;
    		}

    		if ( round > max_round) {
    			return 0;
    		}
    	}
        return 0;
    }
    public boolean compare(String word1, String word2) {
        if(word1.length()==0) return false;
        if(word1.length()==1) return true;
    	int count = 0;
    	for ( int i = 0; i < word1.length() ; i++ )
    		if( word1.charAt(i) != word2.charAt(i) )
    			count++;
    	return count == 1 ? true : false;
    }
}
