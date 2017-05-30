public class Solution {
    public int nthUglyNumber(int n) {
    	int[] ugly = new int[n+1];
    	ugly[1] = 1;

    	int idx2 = 1;
    	int idx3 = 1;
    	int idx5 = 1;

    	int fac2 = 2;
    	int fac3 = 3;
    	int fac5 = 5;

    	for ( int i = 2; i <= n ; i++ ) {
    		int min = Math.min(Math.min(fac2, fac3), fac5);
    		ugly[i] = min;
    		if ( min == fac2 ) {
    			fac2 = 2 * ugly[++idx2];
    		}
    		if ( min == fac3 ) {
    			fac3 = 3 * ugly[++idx3];
    		}
    		if ( min == fac5 ) {
    			fac5 = 5 * ugly[++idx5];
    		}
    	}
    	return ugly[n];
    }
}