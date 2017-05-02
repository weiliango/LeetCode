public class Solution {
	public int findMinArrowShots(int [][] points) {
	    if(points.length == 0) return 0;
		Arrays.sort(points, new Comparator<int[]>(){
			@Override
			public int compare(int[] i1, int[] i2) {
				return i1[1] - i2[1];
			}
		});

		int end     = points[0][1];
		int arrow	= 1;

		for ( int i = 1; i < points.length ; i++ ) {
			if ( points[i][0] <= end ) {
				continue;
			}
			arrow++;
			end = points[i][1]; 
		}

		return arrow;

	}
}