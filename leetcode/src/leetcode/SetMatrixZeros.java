package leetcode;

public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        boolean isFirstColZero = false;
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == 0) {
                    if(c == 0) {
                        // first column should fill with 0
                        isFirstColZero = true;
                    } else {
                        matrix[0][c] = 0;
                        matrix[r][0] = 0;
                    }
                }
            }
        }
        
        for(int r = 1; r < matrix.length; r ++) {
            for(int c = 1; c < matrix[r].length; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0) {
            for(int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
        
        if(isFirstColZero) {
            for(int r = 0; r < matrix.length; r ++) {
                matrix[r][0] = 0;
            }
        }
    }
	
}
