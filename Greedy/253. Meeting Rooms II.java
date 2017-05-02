/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Interval {
	int start;
	int end;
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		int rooms = 0;
		int count = intervals.length;

		while( count != 0 ) {
			rooms += 1;
			int end = 0;
			for ( int i = 0; i < intervals.length ; i++ ) {
				if ( intervals[i] != null ) {
					if ( intervals[i].start >= end ) {
						end = intervals[i].end;
						intervals[i] = null;
						count--;
					}
				}
			}
		}   

		return rooms;

    }
}