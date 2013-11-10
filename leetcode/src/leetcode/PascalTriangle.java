package leetcode;

import java.util.ArrayList;

public class PascalTriangle {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows < 1) {
            return result;
        }
        
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        
        ArrayList<Integer> next = firstRow;
        for(int i = 2; i <= numRows; i++) {
            next = generateNextRow(next);
            result.add(next);
        }    
        
        return result;
    }
    
    
    public ArrayList<Integer> generateNextRow(ArrayList<Integer> prev) {
        ArrayList<Integer> next = new ArrayList<Integer>();
        
        next.add(prev.get(0)); // add first element
        for(int i = 1; i < prev.size(); i ++) {
            next.add(prev.get(i-1) + prev.get(i));
        }
        next.add(prev.get(prev.size() - 1)); // add last element
        
        return next;
    }
	
}
