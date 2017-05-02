public class Interval {
	int start;
	int end;
}

public class Solution {
	public int eraseOverlapIntervals(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			}
		});

		int end 	= Integer.MIN_VALUE;
		int count 	= 0;

		for ( int i = 0; i < intervals.length; i++ ) {
			if ( intervals[i].start >= end ) {
				count++; 
				end = intervals[i].end;
			}
		}

		return intervals.length - count;
	}
}