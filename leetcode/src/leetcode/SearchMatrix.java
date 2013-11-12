package leetcode;

public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int rowL = 0, rowH = matrix.length - 1;
        while(rowL < rowH) {
            int mid = (rowL + rowH);
            if(matrix[mid][0] > target) {
                rowH = mid - 1;
            } else {
                rowL = mid;
            }
        }
        
        if(rowL > rowH) {
            return false;
        }
        
        int colL = 0, colH = matrix[rowL].length - 1;
        while(colL < colH) {
            int mid = (colL + colH);
            if(matrix[rowL][mid] > target) {
                colH = mid - 1;
            } else {
                colL = mid;
            }
        }
        
        if(colL > colH) {
            return false;
        } else {
            return matrix[rowL][colL] == target;
        }
    }
	
}
