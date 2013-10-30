package leetcode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // idea from others
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next;
            if(fast == slow) {
                return true;
            }
        }
        
        return false;
    }
	
}
