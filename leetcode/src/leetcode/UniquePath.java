package leetcode;

public class UniquePath {

	public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int[][] func = new int[m][n];
        //last row
        for(int c = 0; c < n; c ++) {
            func[m-1][c] = 1;
        }
        
        //last col
        for(int r = 0; r < m; r ++) {
            func[r][n-1] = 1;
        }
        
        for(int r = m-2; r >= 0; r--) {
            for(int c = n-2; c >= 0; c--) {
                func[r][c] = func[r+1][c] + func[r][c+1];
            }
        }
        
        return func[0][0];
    }
	
}
