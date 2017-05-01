public class Solution {
	public boolean canJump(int [] nums) {
		if ( nums.length < 2 ) {
			return true;
		}
		for ( int i = 0; i < nums.length - 1; i++ ) {
			if ( nums[i] == 0 ) {
				int j = i - 1;
				while ( j >= 0 ) {
					if ( nums[j] - (i - j) > 0 ) {
						break;
					}
					j--;
				}
				if ( j < 0 ) {
					return false;	
				}
			}			
		}

		return true;
	}
}