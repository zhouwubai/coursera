package leetcode;

public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                break;
            }
        }
        
        if(fast == null || fast.next == null) {
            return null;//no cycle
        }
        
        //k steps, k = d * n = m + r + d^ * n
        // m + r = (d - d^) * n; which indicates following
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
	
}
