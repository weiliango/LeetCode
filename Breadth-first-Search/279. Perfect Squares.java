public class Solution {
	Queue <Integer> q = new LinkedList<Integer>();

    public int numSquares(int n) {
    	List<Integer> wordList = new LinkedList<Integer>();
        for ( int i = 1; i*i <= n; i++ ) {
        	wordList.add(i*i);
        }
        return bfs(n, wordList);
    }

    public int bfs(int target, List<Integer> wordList) {
    	
    	q.clear();
    	for ( int i = 0; i < wordList.size() ; i++ ) {
    		q.add(wordList.get(i));
    	}

    	int round = 1;
    	int size = q.size();

    	while ( !q.isEmpty() ) {
    		
    		int current = q.poll();
    		if ( current == target ) {
    			return round;
    		}

    		for ( int i = 0; i < wordList.size() ; i++ ) {
    			int sum = wordList.get(i) + current;
    			if ( !q.contains(sum) && sum <= target ) {
					q.add(sum);    				
    			}
    		}

    		if ( --size == 0 ) {
    			size = q.size();
    			round++;
    		}
    	}
    	return 0;
    }
}