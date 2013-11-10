package leetcode;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int row = grid.length;
        int col = grid[0].length;
        if(row == 0 && col == 0) return 0;
        int[][] dp = new int[row][col];
        
        //for fist row
        dp[0][0] = grid[0][0];
        for(int c = 1; c < col; c++) {
            dp[0][c] = dp[0][c-1] + grid[0][c];
        }
        
        //for first column
        for(int r = 1; r < row; r ++) {
            dp[r][0] = dp[r-1][0] + grid[r][0];
        }
        
        for(int r = 1; r < row; r++) {
            for(int c = 1; c < col; c++) {
                dp[r][c] = Math.min(dp[r-1][c],dp[r][c-1]) + grid[r][c];
            }
        }
        
        return dp[row-1][col-1];
    }
	
}
