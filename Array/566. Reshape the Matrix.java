public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
    	if ( nums.length == 0 ) return nums;
    		
 		int n = nums.length;
 		int m = nums[0].length;

 		if ( m * n != r * c ) return nums;

 		int res[][] = new int [r][c];
 		int cr = 0; // current r
 		int cc = 0; // current c
 		for ( int i = 0; i < n ; i++ ) {
 			for ( int j = 0; j < m ; j++) {
 				if ( cc == c ) {
 					cc= 0;
 					cr++;
 				}
				res[cr][cc] = nums[i][j];
				cc++;
 			}
 		}
 		return res;
    }
}