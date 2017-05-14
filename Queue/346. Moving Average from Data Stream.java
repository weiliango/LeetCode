public class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> q = new LinkedList<Integer>();
    int size = 0;
    int sum = 0;
    public MovingAverage(int size) {
        q.clear();
        this.size = size;
    }
    
    public double next(int val) {
    	sum += val;
    	q.add(val);
    	if ( q.size() <= size ) {
    		return 1.0 * sum / q.size();
    	} else {
    		sum -= q.poll();
    		return 1.0 * sum / size;
    	}
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */