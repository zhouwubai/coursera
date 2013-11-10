package leetcode;

public class RotateImage {

	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        for(int row = 0; row < n/2; row ++) {
            int start = row,end = (n - 1) - row - 1;
            for(int col = start; col <= end; col ++) {
                int tmp = matrix[row][col];
                
                //replace left top with left bottom
                matrix[row][col] = matrix[n-1-col][row];
                //replace left bottom with right bottom
                // equal to rotate (row,col) 180 degree
                matrix[n-1-col][row] = matrix[n-1-row][n-1-col];
                //replace right bottom with right top
                matrix[n-1-row][n-1-col] = matrix[col][n-1-row];
                //replace right top with left top
                matrix[col][n-1-row] = tmp;
            }
        } 
    }
	
}
