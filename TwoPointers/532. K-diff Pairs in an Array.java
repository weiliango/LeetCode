public class Solution {
    public int findPairs(int[] nums, int k) {
    	if ( nums.length < 2 || k < 0 ) {
    		return 0;
    	}
    	
 		Arrays.sort(nums);
 		int p 	= 0;
 		int q 	= 1;
 		int res = 0;

 		while ( p < nums.length - 1 ) {
 		 //   System.out.println(p);
 		 //   System.out.println(q);
 			while ( q < nums.length && nums[q] - nums[p] < k ) {
 				q++;
 			}
 			if ( q == nums.length ) q--;
  			while ( q >= 0 && nums[q] - nums[p] > k ) {
 				q--;
 			}
 			if ( q < 0 ) {
 				q++;
 			}
 			if ( nums[q] - nums[p] == k && p != q ) {
 				res++;
 			}
 			while ( p+1 < nums.length && nums[p+1] == nums[p] ) {
 			    p++;
 			}
 	        p++;
 	        if ( p >= q ) {
 	        	q = p + 1;
 	        }
 		}

		return res;
    }
}