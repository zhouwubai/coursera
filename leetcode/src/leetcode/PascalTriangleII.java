package leetcode;

import java.util.ArrayList;

public class PascalTriangleII {

	public ArrayList<Integer> getRow(int rowIndex) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }
        
        // c_{n}^{k} = c_{n-1}^{k-1} + c_{n-1}^{k}
        for(int row = 0; row <= rowIndex; row ++) {
            int prev = result.get(0);
            for(int pos = 1; pos < row; pos ++) {
                int next = result.get(pos);
                result.set(pos,prev + next);
                prev = next;
            }
        }
        
        return result;
    }
	
}
