package leetcode;

public class NumTrees {

	public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // when n = 0, this happens when applying recursive method
        if(n <= 1) {
            return 1;
        }else {
            // for every possible root, we calculate #no of left subtree, #no right subtrees
            // then multiple them
            int sum = 0;
            for(int root = 1; root <= n; root ++) {
                int left = numTrees(root - 1); // all left elements less than root 
                int right = numTrees(n - root); // all right elements greater than root
                sum += left * right;
            }
            return sum;
        }
        
    }
	
}
