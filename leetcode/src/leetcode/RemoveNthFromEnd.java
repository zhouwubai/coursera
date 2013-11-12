package leetcode;

public class RemoveNthFromEnd {

	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode first = head;
        ListNode second = head;
        
        for(int i = 0; i < n; i++) {
            second = second.next;
        }
        
        if(second == null) {// head should be removed
            head = head.next;
            return head;
        }
        
        //stop when Nth node is next to first
        while(second.next != null) {
            first = first.next;
            second = second.next;
        }
        
        first.next = first.next.next;
        return head;
    }
	
}
