public class Solution {
	HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
    public String minWindow(String s, String t) {     
    	map.clear();
    	for ( int i = 0; i < t.length(); i++ ) {
    		map.put(t.charAt(i), -1);  	
	  	}  
	  	int min = Integer.MAX_VALUE;
	  	StringBuilder sb = new StringBuilder();
	  	for ( int i = 0; i < s.length(); i++ ) {
			if ( t.indexOf(s.charAt(i)) != -1 ) {
  				map.put(s.charAt(i), i);		
 				TreeMap<Integer, Character> treeMap = new TreeMap<Integer, Character>();
 				for ( Character key : map.keySet() ) {
 					treeMap.put(map.get(key), key);
 				}
 				if ( treeMap.firstKey() != -1 ) {
 					int _min = treeMap.lastKey() - treeMap.firstKey();
 					if ( _min <= min ) {
 						// sb.setLength(0);
 						min = _min;
                        sb = new StringBuilder(s.substring(treeMap.firstKey(), treeMap.lastKey()));
 					}
 				}
	  		}	  		
	  	}
	  	return sb.toString();
    }
    // public int currWindows(HashMap<Character, Integer> map) {
    // 	int max = Integer.MIN_VALUE;
    // 	int min = Integer.MAX_VALUE;
    // 	for ( Integer v : map.values() ) {
    // 		if ( v == -1 ) {
    // 			return Integer.MAX_VALUE;
    // 		}
    // 		max = Math.max(max, v);
    // 		min = Math.min(min, v);
    // 	}
    // 	return max - min;
    // }
}