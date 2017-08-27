class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length < 1) return false;
        if(nums.length < 3) return true;
        boolean[][] dp = new boolean[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++)
            dp[i][i] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(dp[i][j-1] && nums[j] >= nums[j-1])
                    dp[i][j] = true;
            }
        }
        if(dp[1][nums.length-1] || dp[0][nums.length-2] ) return true;
        for(int i = 1; i < nums.length - 1; i++) {
            if(dp[0][i-1] && dp[i+1][nums.length-1] && nums[i-1] <= nums[i+1])
                return true;
        }
        return false;
    }
}