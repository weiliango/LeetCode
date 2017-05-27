public class Solution {
    public int maximalSquare(char[][] matrix) {
        if ( matrix.length < 1 ) 
        	return 0;

    	int max = 0;
    	int [][] dp = new int [matrix.length][matrix[0].length];

    	for ( int i = 0; i < matrix.length ; i++ ) {
    		for ( int j = 0; j < matrix[0].length ; j++ ) {
    			if ( matrix[i][j] == '1' ) {
    				dp[i][j] = 1;
    				max = Math.max(max, 1);
    			}
    			if ( i > 0 && j > 0 && dp[i-1][j-1] != 0 ) {
    				int curr = 0;
    				for ( int k = 0; k <= dp[i-1][j-1] ; k++ ) {
    					if ( dp[i][j-k] != 0 && dp[i-k][j] != 0 ) {
    						curr++;
    					} else {
    						break;
    					}
    				}
					dp[i][j] = curr;
					max = Math.max(max, dp[i][j]);
    			}
    		}
    	}
    	return max * max;
    }
}