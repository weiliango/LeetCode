public class Solution {
    public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int p = 0;
		int q = nums.length - 1;

		while( p <= q ) {
			if ( nums[p] == val ) {
				nums[p] ^= nums[q];
				nums[q] ^= nums[p];
				nums[p] ^= nums[q];
				length--;
				q--;
			} else {
				p++;
			}
		}

		return length;
    }
}