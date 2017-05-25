public class Solution {
    public int maxProduct(int[] nums) {
 		int [] arr_pos = new int [nums.length + 1];
 		int [] arr_neg = new int [nums.length + 1];

 		//Arrays.fill(arr_pos, 1);
 		//Arrays.fill(arr_neg, 1);
 		arr_pos[0] = 1;
 		arr_neg[0] = 1; 

 		int max = Integer.MIN_VALUE;

 		for ( int i = 1; i < arr_pos.length ; i++ ) {
 			if ( nums[i-1] >= 0 ) {
 				arr_pos[i] = Math.max(nums[i-1]*arr_pos[i-1], nums[i-1]);
 				arr_neg[i] = nums[i-1]*arr_neg[i-1];
 			} else {
 				arr_pos[i] = nums[i-1]*arr_neg[i-1];
 				arr_neg[i] = Math.min(nums[i-1]*arr_pos[i-1], nums[i-1]);
 			}
 			max = Math.max(max, arr_pos[i]);
 		}
 		return max;
    }
}