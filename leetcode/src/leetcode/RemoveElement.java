package leetcode;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(A.length == 0) return 0;
        
        int head = 0;
        int tail = A.length - 1;
        while(true) {
            while(head < tail && A[head] != elem) head ++;
            while(tail > head && A[tail] == elem) tail --;
            
            if(head < tail) {
                A[head] = A[tail];
                tail --;
                continue;
            }
            
            if(head == tail) break;
        }
        
        if(A[head] == elem)
                return head;
            else
                return head + 1;
    }
	
}
