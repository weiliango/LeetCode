public class Solution {
    public int coinChange(int[] coins, int amount) {
    	if ( amount == 0 ) {
    		return 0;
    	}
		int [] dp = new int [amount + 1];
		Arrays.fill(dp, amount + 1);
		for ( int coin : coins ) {
			if ( coin > amount ) {
				continue;
			}
			dp[coin] = 1;
		}
		for ( int i = 1; i <= amount ; i++ ) {
			for ( int coin: coins ) {
				if ( i >= coin ) {
					dp[i] = Math.min(dp[i], dp[i-coin] + 1);
				}
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
    }
}