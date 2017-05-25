public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
    	int res = 0;
 		for ( int i = 1; i <= n ; i++ ) {
 			res = res * 10 * (n-1) + 9 * res;       	
        }       
        return Math.pow(10,n) - res;
    }
}