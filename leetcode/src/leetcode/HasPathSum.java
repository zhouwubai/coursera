package leetcode;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return false;//trivial solution
        
        // it is a leaf
        if(root.left == null && root.right == null) {
            if(sum == root.val) return true;
            else return false;
        }else {
            if(root.left != null){
                boolean left = hasPathSum(root.left, sum - root.val);
                if(left == true) return true;
            }
            
            if(root.right != null) {
                boolean right = hasPathSum(root.right, sum - root.val);
                if(right == true) return true;   
            }
            
            return false;// if left and right are all false;
        } 
    }
	
}
