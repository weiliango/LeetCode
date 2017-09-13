/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)
                    return o1.start - o2.start;
                else
                    return o1.end - o2.end;
            }
        });
        List<Interval> res = new LinkedList<>();
        if(intervals == null || intervals.size() == 0) return res;
        Integer start = null, end = null;
        for(Interval interval: intervals) {
            if(start == null) {
                start = interval.start;
                end = interval.end;
            } else {
                if(end >= interval.start) {
                    end = Math.max(interval.end, end);
                } else {
                    res.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}