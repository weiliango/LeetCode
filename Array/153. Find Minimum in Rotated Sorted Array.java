public class Solution {
	public int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while ( start < end ) {
			if ( nums[start] <= nums[end] ) {
				return nums[start];
			}
			int mid = ( start + end ) / 2;
			if ( nums[mid] >= nums[start] ) {
				start = mid + 1;
			}
			if ( nums[mid] <= nums[end] ) {
				end = mid;
			}
		}
		return nums[start];
	}
}