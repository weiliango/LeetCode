public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
 		int p1 = -1;
 		int p2 = -1;
 		int min = Integer.MAX_VALUE;
 		for ( int i = 0; i < words.length ; i++ ) {
 			if ( word1.equals(words[i]) ) {
 				p1 = i;
 			}
 			if ( word2.equals(words[i]) ) {
 				p2 = i;
 			}
 			if ( p1 != -1 && p2 != -1 ) {
	 			min = Math.min(min, Math.abs(p2-p1));
 			}
 		}
 		return min;
    }
}