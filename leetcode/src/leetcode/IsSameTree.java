package leetcode;

public class IsSameTree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(p == null && q == null) {
            return true;
        }else if(p != null && q != null && p.val == q.val) {
            
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
            
        }else {
            return false;
        }
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
}
