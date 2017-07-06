public class NumArray {
	int[] dp;
    int[] arr;
    public NumArray(int[] nums) {
    	if ( nums == null || nums.length < 1 ) return;
        dp = new int[nums.length];
        dp[0] = nums[0];
        for ( int i = 1; i < nums.length; dp[i] = dp[i-1] + nums[i], i++ );
        arr = nums;
    }
    
    public void update(int i, int val) {
        if ( dp == null ) return;
        dp[i] += val - arr[i];
        arr[i] = val;
        for ( int idx = i + 1; idx < arr.length; dp[idx] = dp[idx-1] + arr[i], idx++ );
    }
    
    public int sumRange(int i, int j) {
        if ( dp == null ) return 0;
        return dp[j] - ( i > 0 ? dp[i-1] : 0 );
    }
}
// this solution is not optimal, cannot pass testcases, runtime

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */


public class NumArray {
    int[] nums;
    int[] bit;
    
    public NumArray(int[] nums) {
        bit = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            int index = i + 1;
            while ( index < bit.length ) {
                bit[index] += nums[i];
                index += index & (-index);
            }
        }
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        int idx = i + 1;
        while ( idx < bit.length ) {
            bit[idx] += val - nums[i];
            idx += idx & (-idx);
        }
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        j++;
        while( j > 0 ) {
            sum += bit[j];
            j -= j & (-j);
        }
        while( i > 0 ) {
            sum -= bit[i];
            i -= i & (-i);
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