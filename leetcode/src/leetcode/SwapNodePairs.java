package leetcode;

public class SwapNodePairs {

	public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null  || head.next == null) return head;
        
        ListNode subHead = head.next.next;
        
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(subHead);
        
        return newHead;
    }
	
}
