class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        int max = 0;
        for(int i = 1; i <= nums.length; i++) {
            max = Math.max(max, search(i, nums.length, dp, nums));
        }
        return max;
    }
    private int search(int i, int j, int[][] dp, int[] nums) {
        if(dp[i][j] != 0) return dp[i][j];
        for(int idx = i + 1; idx <= j; idx++) {
            if(nums[i-1] < nums[idx-1]) {
                dp[i][j] = Math.max(dp[i][j], search(idx, j, dp, nums) + 1);
            }
        }
        // visited[i][j] = true;
        return (dp[i][j] == 0 ? 1: dp[i][j]);
    }
}