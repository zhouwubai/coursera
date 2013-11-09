package leetcode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int rtn = checkBalanceOrHeight(root);
        return rtn < 0 ? false : true;
    }
    
    
    public int checkBalanceOrHeight(TreeNode root) {
        if(root == null) return 0;
        
        int left = checkBalanceOrHeight(root.left);
        int right = checkBalanceOrHeight(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left,right) + 1;
    }
	
}
