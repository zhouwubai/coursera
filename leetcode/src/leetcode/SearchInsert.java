package leetcode;

public class SearchInsert {

	public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int pos = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > target) {
                return pos;
            }else if(A[i] == target) {
                return i;
            }else {
                pos = i + 1;
            }
        }
        return pos;
    }
	
}
