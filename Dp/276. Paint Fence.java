public class Solution {
    public int numWays(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int j = 1; j <= k; j++) {
            dp[0][i] = 1;
            dp[1][i] = k;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= k; k++) {
                for(int x = 1; x <= k; x++) {
                    if(x != j)
                        dp[i][j] += dp[i-1][x];
                    else
                        dp[i][j] += dp[i-1][x] - dp[i-2][x];
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= k; i++)
            res += dp
    }
}