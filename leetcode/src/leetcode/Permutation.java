package leetcode;

import java.util.ArrayList;

public class Permutation {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> rtn = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int curPos = 1;
        combine(rtn,cur,curPos,n,k);
        return rtn;
    }
    
    private void combine(
                ArrayList<ArrayList<Integer>> rtn,
                ArrayList<Integer> cur,int curPos, int n, int k) {
        if(cur.size() == k) {
            rtn.add(cur);
            return;
        }
        
        if(curPos == n + 1) {
            return;
        }
        
        ArrayList<Integer> addOne = new ArrayList<Integer>(cur);
        addOne.add(curPos);
        combine(rtn,addOne,curPos + 1,n,k);
        
        //skip curPos to next
        combine(rtn,cur,curPos + 1,n,k);
    }
	
}
