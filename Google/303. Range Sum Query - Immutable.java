public class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        for ( int i = 1; i < nums.length; nums[i] += nums[i-1], i++ );
        dp = nums;
    }
    
    public int sumRange(int i, int j) {
        return dp.length > 0 ? dp[j] - ( i != 0 ? dp[i-1] : 0 ) : 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */