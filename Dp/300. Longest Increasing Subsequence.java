public class Solution {
    public int lengthOfLIS(int[] nums) {
    	if ( nums.length < 2 ) {
    		return nums.length;
    	}
 		int [] dp = new int[nums.length+1];
 		int max   = 1;
 		for ( int i = 1; i < dp.length; i++ ) {
 			dp[i] = 1;
 			int j = i - 1;
 			while ( j > 0 ) {
 				if ( nums[j-1] < nums[i-1] ) {
 					dp[i]	= Math.max(dp[i], dp[j] + 1);
 					max 	= Math.max(dp[i], max); 
 				}
 				j--;
 			}
 		}
 		return max;
    }
}