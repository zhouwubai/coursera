package leetcode;

public class RemoveDuplicates {

	public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length <= 1) {
            return A.length;
        }
        int n = A.length;
        int current = 0;
        for(int i = 1; i < n;) {
            while(i < n && A[i] == A[current]) {
                i ++;
            }
            
            if(i == n) {
                return current + 1;
            }else { // find a different value
                A[++current] = A[i++];
            }
        }
        return current + 1;
    }
	
}
