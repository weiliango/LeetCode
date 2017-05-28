public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
    	int max 	 = 0;
    	int [][] arr = new int[m][n];
    	int count 	 = m * n;
    	for ( int[] op : ops ) {
    		// if ( op[0] >= m || op[1] >= n || op[0] <0 || op[1] < 0 ) {
    		// 	return 0;
    		// }
	 		for ( int i = 0; i < op[0] ; i++ ) {
	 		    for ( int j = 0; j < op[1] ; j++ ) {
	 				arr[i][j] += 1;
	 				if ( arr[i][j] > max ) {
	 					max = arr[i][j];
	 					count = 1;
	 					continue;
	 				}
	 				if ( arr[i][j] == max ) {
	 					count += 1;
	 				}
	 		    }
	        }       
		}
        return count;
    }
}