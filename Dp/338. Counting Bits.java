public class Solution {
    public int[] countBits(int num) {
    	int[] arr = new int[num+1];
    	int count = 1;
    	for ( int i = 1; i < arr.length ; i++ ) {
    		if ( i * 2 == (i+(i&(-i)))) {
    			arr[i] = 1;
    		} else if ( i % 2 == 0 ) {
    		    arr[i] = arr[(i >> 1)];
    		} else {
    			arr[i] = arr[i-1] + 1;
    		}
    	}
    	return arr;
    }
}