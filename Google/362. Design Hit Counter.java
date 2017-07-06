public class HitCounter {
    int[] hits;
    int[] times;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        times = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (times[timestamp % 300] != timestamp) {
            times[timestamp % 300] = timestamp;
            hits[timestamp % 300] = 1;
        } else {
            hits[timestamp % 300] += 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int result = 0;
        for ( int i = 0; i < 300; i++ ) {
            if ( timestamp - times[i] < 300) {
                result += hits[i];
            }
        }
        return result;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */