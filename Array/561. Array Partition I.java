public class Solution {
    public int arrayPairSum(int[] nums) {
    	int minSum = 0;
 		Arrays.sort(nums);
 		for ( int i = 0; i < nums.length ; i++ ) {
 			if ( i % 2 == 0) {
	 			minSum += nums[i];
 			}
        }       
        return minSum;
    }
}