public class Solution {
    public String longestPalindrome(String s) {
    	if ( s.length() == 0 ) {
    		return "";
    	}
 		int [][] dp 		= new int [s.length()][s.length()];
 		int [][][] backtrack 	= new int [s.length()][s.length()][2];
 		for ( int i = s.length() - 1; i >= 0 ; i-- ) {
 			dp[i][i] = 1;
        	for ( int j = i + 1; j < s.length() ; j++ ) {
        		if ( s.charAt(i) == s.charAt(j) ) {
        			dp[i][j] = dp[i+1][j-1] + 2;
        			backtrack[i][j][0] = i + 1;
        			backtrack[i][j][1] = j - 1;
        		} else {
        			continue;
        		}
        		// } else {
        		// 	// if ( dp[i+1][j] > dp[i][j-1] ) {
        		// 		// dp[i][j] = dp[i+1][j];
        		// 		backtrack[i][j][0] = i + 1;
        		// 		backtrack[i][j][1] = j;
        		// 	} else {
        				// dp[i][j] = dp[i][j-1];
        				// backtrack[i][j][0] = i;
        				// backtrack[i][j][1] = j - 1;
        			// }
        		}
			}		
        }        
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        int head = 0;
        while ( backtrack[i][j][0] != 0 || backtrack[i][j][1] != 0 ) {
        	// if ( s.charAt(i) == s.charAt(j) ) {
        		sb.insert(head, s.charAt(i));
        		sb.insert(++head, s.charAt(j));
        	// }
        	int m = backtrack[i][j][0];
        	int n = backtrack[i][j][1];
        	i = m;
        	j = n;
        }
        if ( i == j ) {
        	sb.insert(head, s.charAt(i));
        }
        return sb.toString();
    }
}