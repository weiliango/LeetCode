public class WordDistance {
	HashMap <String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public WordDistance(String[] words) {
    	for ( int i = 0; i < words.length ; i++ ) {
    		if ( map.containsKey(words[i]) ) {
    			List<Integer> list = map.get(words[i]);
    			list.add(i);
    			map.put(words[i], list);
    		} else {
    			List <Integer> list = new LinkedList <Integer>();
    			list.add(i);
    			map.put(words[i], list);
    		}
    	}
    }
    
    public int shortest(String word1, String word2) {
    	int min = Integer.MAX_VALUE;
        for ( int p1 : map.get(word1)) {
        	for ( int p2 : map.get(word2)) {
        		min = Math.min(min, Math.abs(p2-p1));
        	}
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */