public class Solution {
    public int combinationSum4(int[] nums, int target) {
    	if ( target <= 0 ) {
    		return 1;
    	}
 		int [] dp = new int[target+1];
 		for ( int num : nums ) {
 			if ( num <= target ) {
	 			dp[num] = 1;       	
 			}
        }       
        for ( int i = 1; i <= target; i++ ) {
        	for ( int num : nums ) {
        		dp[i] = i > num ? dp[i-num] + dp[i] : dp[i];	
        	}
        }
        return dp[target];
    }
}