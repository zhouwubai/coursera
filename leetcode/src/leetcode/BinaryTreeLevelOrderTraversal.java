package leetcode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        
        level.add(root);//first level
        while(level.size() > 0) {
            result.add(convertTreeNode(level));
            level = findNextLevel(level);//last level will be empty, then its size == 0
        }
        return result;
    }
    
    
    public ArrayList<TreeNode> findNextLevel(ArrayList<TreeNode> prevLevel) {
        
        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
        for(TreeNode node : prevLevel) {
            if(node.left != null) {
                nextLevel.add(node.left);
            }
            if(node.right != null) {
                nextLevel.add(node.right);
            }
        }
        return nextLevel;
    }
    
    
    public ArrayList<Integer> convertTreeNode(ArrayList<TreeNode> nodes) {
        ArrayList<Integer> rtn = new ArrayList<Integer>();
        for(TreeNode node : nodes) {
            rtn.add(node.val);
        }
        return rtn;
    }
	
}
