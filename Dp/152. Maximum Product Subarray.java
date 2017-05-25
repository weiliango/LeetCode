public class Solution {
    public int maxProduct(int[] nums) {
 		int [] arr = new int [nums.length + 1];
 		arr[0] = 1;
 		int max = Integer.MIN_VALUE;
 		for ( int i = 1; i < arr.length ; i++ ) {
 			arr[i] = Math.max(arr[i-1]*nums[i-1], nums[i-1]);      	
 			max = Math.max(arr[i], max);
        }       
        return max;
    }
}