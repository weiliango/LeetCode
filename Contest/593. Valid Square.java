public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    	if ( distance(p1,p2) == 0 
    		|| distance(p1,p3) == 0
    		|| distance(p1,p4) == 0
    		|| distance(p2,p3) == 0
    		|| distance(p2,p4) == 0
    		|| distance(p3,p4) == 0) {
    		return false;
    	}
 		int [] mid = new int [2];
 		p1[0] *= 4;
 		p1[1] *= 4;

 		p2[0] *= 4;
 		p2[1] *= 4;

 		p3[0] *= 4;
 		p3[1] *= 4;

 		p4[0] *= 4;
 		p4[1] *= 4;

 		mid[0] = (p1[0] + p2[0] + p3[0] + p4[0])/4;
 		mid[1] = (p1[1] + p2[1] + p3[1] + p4[1])/4;

 		double [] range = new double[4];
 		range[0] = Math.pow(p1[0] - mid[0], 2) + Math.pow(p1[1] - mid[1], 2);
 		range[1] = Math.pow(p2[0] - mid[0], 2) + Math.pow(p2[1] - mid[1], 2);
 		range[2] = Math.pow(p3[0] - mid[0], 2) + Math.pow(p3[1] - mid[1], 2);
 		range[3] = Math.pow(p4[0] - mid[0], 2) + Math.pow(p4[1] - mid[1], 2);

 		double value = range[0];
 		for ( int i = 0; i < 4 ; i++ ) {
 			if ( range[i] != value ) {
 				return false;
 			}
 		}

 		if ( !((p1[0] + p2[0])/2 == mid[0] && (p1[1] + p2[1])/2 == mid[1]) ) {
 			// p1 p2 not dui jiao xian
 			if ( distance(p1, p2) == distance(p2,p3) || distance(p1,p2) == distance(p1,p3)) {
 				return true;
 			}
 		} else {
 			if ( distance(p1, p3) == distance(p2,p3) ) {
 				return true;
 			}
 		}

 		return false;
    }
    public double distance(int[] p1, int[] p2 ) {
    	return Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2);
    }
}