// public class Solution {
//     public int numSquares(int n) {
//       //   int [] candidates = new int [(int)Math.sqrt(n)+1];
//      	// for ( int i = 1; Math.pow(i, 2) <= n ; i++ ) {
//      	//    	candidates[i] = (int) Math.pow(i, 2);
//  	    // }
//  	    Queue<Integer> q = new LinkedList<Integer>();
//  	    q.add(0);
//  	    int round = 0;
//  	    int size  = q.size();
//  	    int length= (int) Math.sqrt(n);
//  	    while ( !q.isEmpty() ) {
//  	    	int curr = q.poll();
//  	    	if ( curr == n ) {
//  	    		return round;
//  	    	}
//  	    	for ( int i = 1; i <= length ; i++ ) {
//  	    		int _pow = (int)Math.pow(i, 2);
//  	    		if ( _pow + curr < n ) {
//  	    			q.add(_pow + curr);
//  	    		} else if ( _pow + curr == n){
//  	    			return round;
//  	    		} else {
//  	    			break;
//  	    		}
//  	    	}

//  	    	if ( --size == 0 ) {
//  	    		size = q.size();
//  	    		round++;
//  	    	}
//  	    }
//  	    return 0;
//     }
// }
public class Solution {
    public int numSquares(int n) {
 		int [] arr = new int [n+1];
 		Arrays.fill(arr, Integer.MAX_VALUE);
 		arr[0] = 0;
 		for ( int i = 1; i <= n ; i++ ) {
 			for ( int j = 1; Math.pow(j,2) <= i; j++ ) {
 				arr[i] = Math.min(arr[i], arr[i-(int)Math.pow(j,2)] + 1);
 			}
 		}       
 		return arr[n];
    }
}