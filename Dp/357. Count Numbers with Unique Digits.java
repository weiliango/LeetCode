public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
    	if ( n < 0 || n > 11 ) {
    		return 0;
    	}
    	if ( n == 0 ) return 1;

    	int sum 	= 10;// n = 1 & n = 0
    	int count 	= 9; // when n = 1 
    	int multi 	= 9;

 		for ( int i = 2; i <= n ; i++ ) {
 			count 	*= multi--;
 			sum 	+= count;
        }       
        return sum;
    }
}