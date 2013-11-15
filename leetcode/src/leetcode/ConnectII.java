package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectII {

	public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
        TreeLinkNode sentinel = new TreeLinkNode(0);
        TreeLinkNode prev = root;
        qu.offer(sentinel);
        
        while(qu.peek() != null) {
             if(prev == sentinel) {
                 prev = qu.poll();//next level
                 qu.offer(sentinel);
             }
             
             //add prev's left and right;
             if(prev.left != null) qu.offer(prev.left);
             if(prev.right != null) qu.offer(prev.right);
             
             TreeLinkNode next = qu.poll();
             if(next == sentinel) {
                 prev.next = null;
             } else {
                 prev.next = next;
             }
             
             prev = next;
        }
    }
	
}
