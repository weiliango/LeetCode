// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// worst case O(N*N), not optimal
class Solution {
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[] P, int K) {
        // write your code in Java SE 8
        int ret = -1;
        Queue<Interval> q = new LinkedList<>();
        q.offer(new Interval(1, P.length));
        int day = 1;
        for(int rose: P) {
            while(!q.isEmpty()) {
               Interval cur = q.poll();
               if(cur.start <= rose && cur.end >= rose) {
                   if(rose - cur.start > 0) q.offer(new Interval(cur.start, rose - 1));
                   if(cur.end - rose > 0) q.offer(new Interval(rose + 1, cur.end));
                   if(rose - cur.start == K || cur.end - rose == K)
                        return day;
                   break;
               }
               else {
                   q.offer(cur);
               }
            }
            day++;
        }
        return ret;
    }
}