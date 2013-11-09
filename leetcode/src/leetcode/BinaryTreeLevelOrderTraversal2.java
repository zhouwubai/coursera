package leetcode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal2 {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> rootLevel = new ArrayList<TreeNode>();
        rootLevel.add(root);
        getLevelOrderFromButton(rootLevel,levels);
        
        //convert to ArrayList<ArrayList<Integer>>
        for(ArrayList<TreeNode> level : levels) {
            ArrayList<Integer> intLevel = new ArrayList<Integer>();
            for(TreeNode node : level) {
                intLevel.add(node.val);
            }
            result.add(intLevel);
        }
        
        return result;
    }
    
    public void getLevelOrderFromButton(ArrayList<TreeNode> prevLevel, 
                        ArrayList<ArrayList<TreeNode>> levels) {
            
            if(prevLevel.size() == 0) {
                 return;
             }
             
             ArrayList<TreeNode> nextLevel = findNextLevel(prevLevel);
             getLevelOrderFromButton(nextLevel,levels);
             levels.add(prevLevel);
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
	
}
