public class NumArray {

	int [] bit;
	int [] nums;

    public NumArray(int[] nums) {
    	this.bit  = new int [nums.length + 1];
    	this.nums = nums;

    	for ( int i = 1; i < bit.length ; i++ ) {
    		bit[i] += nums[i-1];
	    	int next = i + (i & (-i));
	    	while ( next < bit.length ) {
	    		bit[next] += nums[i-1];
	    		next += next & (-next);
	    	}
    	    // update(i, nums[i-1]);	
	    }    
    }
    
    public void update(int i, int val) {
        i = i + 1;
    	int change = val - nums[i-1]; 
    	bit[i] += change;
    	int next = i + (i & (-i));
    	while ( next < bit.length ) {
    		bit[next] += change;
    		next += next & (-next);
    	}
    }
    
    public int sumRange(int i, int j) {
    	// align the index to bit
    	i = i + 1;
    	j = j + 1;
    	// calculate the sum of [0,i] [0,j] seperately
    	
    	int sum = 0;
    	for ( int idx = i - (i & (-i)); idx < i ; idx++ ) {
    		sum -= bit[idx];
    	}
    	
    	//System.out.println(j);
    	//System.out.println(j-(j&(-j)));
    	for ( int idx = j - (j & (-j)); idx <= j ; idx++ ) {
    		sum += bit[idx];
    	//	System.out.println(idx);
    	//	System.out.println(sum);
    	}
    	return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */