public class Solution {
    public int[] findPermutation(String s) {

    	int [] Permu 	= new int[s.length + 1]; 
    	Permu[0]		= 1;
    	int max			= Permu[0];

    	for ( int i = 0; i < s.length(); i++ ) {
    		if ( s.charAt(i) == 'I' ) {
    			Permu[i+1] = max + 1;
    			max++; 
    		} else {
    			Permu[i+1] = Permu[i];
    			for ( int j = i; j >= 0 ; j-- ) {
    				if ( s.charAt(i) == 'D') {
    					Permu[j] = Permu[j+1] + 1;
    					max = Math.max(max, Permu[j]);
    				} else {
    					break;
    				}
    			}
    		}
    	}
    	return Permu;
    }
}