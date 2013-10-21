package leetcode;

public class SingleNumber {

    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int rtn = 0;
        for(int i = 0; i < A.length; i++) {
            rtn ^= A[i];
        }
        
        return rtn;
    }
	
    public static void main(String[] args) {
		
    	System.out.println(-123 / 10);
    	
	}
	
}
