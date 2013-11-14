package leetcode;

public class SearchRotatedSortedArray {

	public int search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length == 0) return -1;

        int n = A.length;
        int start = 0, end = n - 1;
        if(A[start] <= target) {
            while(start < n - 1 && A[start] < A[start + 1]){
               if(A[start] == target) {
                   return start;
               }
               start ++;
            }
           return A[start] == target ? start : -1; 
        }
            
        if(A[end] >= target) {
            while(end > 0 && A[end] > A[end - 1]){
                if(A[end] == target) {
                     return end;
                  }
                 end --;
            }
            return A[end] == target ? end : -1;
        }else {
            return -1;
        }
    }
	
}
