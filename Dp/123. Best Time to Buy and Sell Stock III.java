public class Solution {
   //  public int maxProfit(int[] prices) {
   //  	int max = 0;
 		// for ( int i = 0; i < prices.length; i++ ) {
 		// 	max = Math.max(max, helper(prices, 0, i) + helper(prices, i+1, prices.length - 1));
 		// }       
 		// return max;
   //  }
   //  public int helper(int[] prices, int start, int end) {
   //  	int profit = 0;
   //  	if(start < 0 || end < 0 || start > prices.length - 1 || end > prices.length - 1) return profit;
   //  	int min = prices[start];
   //  	for ( int i = start; i <= end; i++ ) {
   //  		profit = Math.max(prices[i] - min, profit);
   //  		min = Math.min(min, prices[i]);
   //  	}
   //  	return profit;
   //  }
// }
public class Solution {
	public int maxProfit(int[] prices) {
	    if (prices.length < 2) return 0;
		int [] opt_left = new int [prices.length];
		int [] opt_right = new int [prices.length];
		int min = prices[0];
		for ( int i = 1; i < opt_left.length ; i++ ) {
			opt_left[i] = Math.max(prices[i] - min, opt_left[i-1]);
			min = Math.min(min, prices[i]); 
		}
		int max = prices[prices.length-1];
		for ( int i = prices.length - 2; i >= 0 ; i-- ) {
			opt_right[i] = Math.max(max - prices[i], opt_right[i+1]);
			max = Math.max(max, prices[i]);
		}

		int res = opt_left[prices.length - 1];
		for ( int i = 0; i < prices.length - 1 ; i++ ) {
			res = Math.max(res, opt_left[i] + opt_right[i+1]);
		}
		return res < 0 ? 0 : res;
	}
}