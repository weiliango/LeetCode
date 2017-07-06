public class NumMatrix {
	int[][] dp;

    public NumMatrix(int[][] matrix) {
    	if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return;
        dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; dp[i][0] = dp[i-1][0] + matrix[i][0], i++);
        for (int j = 1; j < matrix[0].length; dp[0][j] = dp[0][j-1] + matrix[0][j], j++);
        for (int i = 1; i < matrix.length; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
        		dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + matrix[i][j];
        	} 	
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if ( dp == null ) return 0;
        return dp[row2][col2] 
            - (row1 != 0 ? dp[row1-1][col2] : 0) 
            - (col1 != 0 ? dp[row2][col1-1] : 0) 
            + (row1 != 0 && col1 != 0 ? dp[row1-1][col1-1] : 0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */