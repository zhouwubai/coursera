package leetcode;

public class IsSymmetric {

	public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return true;
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode left, TreeNode right) {
        
        if(left == null && right == null) {
            return true;
        } else if(left != null && right != null) {
            if(left.val != right.val) {
                return false;
            } else {
                return isSym(left.left, right.right) && isSym(left.right, right.left);
            }
        } else {
            return false;
        }
        
    }
	
}


class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}