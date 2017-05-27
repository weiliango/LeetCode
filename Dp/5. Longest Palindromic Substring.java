// public class Solution {
//     public String longestPalindrome(String s) {
//     	if ( s.length() == 0 ) {
//     		return "";
//     	}
//  		int [][] dp 			= new int [s.length()][s.length()];
//  		int [][][] backtrack 	= new int [s.length()][s.length()][2];
//  		int [] max_idx			= new int[2];
//  		int max_value			= Integer.MIN_VALUE;
//  		for ( int i = s.length() - 1; i >= 0 ; i-- ) {
//  			dp[i][i] = 1;
//         	for ( int j = i + 1; j < s.length() ; j++ ) {
//         		if ( s.charAt(i) == s.charAt(j) ) {
//         			if ( dp[i+1][j-1] != 0 || j - i == 1 ) {
// 	        			dp[i][j] = dp[i+1][j-1] + 2;
// 	        			backtrack[i][j][0] = i + 1;
// 	        			backtrack[i][j][1] = j - 1;
// 	        			if ( dp[i][j] > max_value ) {
// 	        				max_value = dp[i][j];
// 	        				max_idx[0] = i;
// 	        				max_idx[1] = j;
// 	        			}
// 	        		}
//         		} 
// 			}		
//         }        
//         int i = max_idx[0];
//         int j = max_idx[1];
//         StringBuilder sb = new StringBuilder();

//         int head = 0;
//         while ( backtrack[i][j][0] != 0 || backtrack[i][j][1] != 0 ) {
//     		sb.insert(head, s.charAt(i));
//     		sb.insert(++head, s.charAt(j));
//         	int m = backtrack[i][j][0];
//         	int n = backtrack[i][j][1];
//         	i = m;
//         	j = n;
//         }
//         if ( i == j ) {
//         	sb.insert(head, s.charAt(i));
//         }
//         return sb.toString();
//     }
// }


public class Solution {
    public String longestPalindrome(String s) {
    	if ( s.length() < 2 ) {
    		return s;
    	}
 		int [][] dp 	= new int[s.length()][s.length()];
 		int max_idx 	= 0;
 		int max_val 	= 1;

 		for ( int i = s.length() - 1; i >= 0 ; i-- ) {
 			dp[i][i] = 1;
 			for ( int j = i + 1; j < s.length() ; j++ ) {
 				if ( s.charAt(i) == s.charAt(j) && ( dp[i+1][j-1] != 0 || j == i + 1)) {
 					dp[i][j] = dp[i+1][j-1] + 2;
 					if ( dp[i][j] > max_val ) {
 						max_val 	= dp[i][j];
 						max_idx	    = i;
 					}
 				}
	       	}       	
       	}       	
       	return s.substring(max_idx, max_idx + max_val);
    }
}