package leetcode;

public class SpiralMatrixII {

	public static int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int levels = (n-1)/2;
        int numberToFill = 1;
        int[][] matrix = new int[n][n];
        
        for(int level = 0; level <= levels; level ++) {
            
            // # of cell to fill in one row of this level(this is not correct for only one in that level)
            // but we can fix by check numberToFill
            int counter = n - 2 * level; 
            int row = level, col = level; //start point for each level;
            
            // fill top row
            for(int cnt = 0; cnt < counter; cnt ++) {
              matrix[row][col++] = numberToFill;
              //check whether it's last element
              if(numberToFill == n * n) {
                  return matrix;
              }
              numberToFill ++;
            }
            
            col --;//adjust
            row ++;
            for(int cnt = 0; cnt < counter - 2; cnt ++) {
                matrix[row++][col] = numberToFill;
                numberToFill ++;
            }
            
            for(int cnt = 0; cnt < counter; cnt ++) {
                matrix[row][col--] = numberToFill;
                numberToFill ++;
            }
            
            col ++;//adjust
            row --;
            for(int cnt = 0; cnt < counter - 2; cnt ++) {
                matrix[row--][col] = numberToFill;
                numberToFill ++;
            }
        }
        
        return matrix;
    }
	
	public static void main(String[] args) {
		
		SpiralMatrixII.generateMatrix(1);
		
	}
	
	
}
