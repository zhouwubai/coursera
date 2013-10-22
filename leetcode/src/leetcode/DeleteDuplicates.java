package leetcode;

public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            while(next != null && current.val == next.val) {
                next = next.next;
            }
            
            if(next == null) {
                current.next = next;
                return head;
            }else {
             current.next = next;
             current = next;
            }
        }
        return head;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}