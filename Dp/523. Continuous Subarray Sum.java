public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
 		int [][] dp = new int[nums.length][nums.length];
 		for ( int i = 0; i < nums.length ; i++ ) {
 			for ( int j = 1; j <= i ; j++ ) {
 				dp[i][i-j] = dp[i][i-j] + nums[i];
 			}
        }    
 		return false;   
    }
}