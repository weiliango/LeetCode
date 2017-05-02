public class Solution {
	public int wiggleMaxLength(int[] nums) {
	    if ( nums.length == 0 ) return 0;
    	int pos = 0;
    	int neg = 0;

    	int pflag = 1;
    	int nflag = -1;

    	for ( int i = 0; i < nums.length - 1; i++ ) {
    		if ( pflag * (nums[i+1] - nums[i]) > 0 ) {
    			pos += 1;
    			pflag *= -1;
    		} 
    		if ( nflag * (nums[i+1] - nums[i]) > 0 ) {
    			neg += 1;
    			nflag *= -1;
    		} 
    	}

    	return (pos > neg ? pos : neg) + 1;
    }
}