package leetcode;

public class Connect {

	public void connect(TreeLinkNode root) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		// check for trivial solution
		if (root == null || root.left == null) {
			return;
		}

		TreeLinkNode prevQ = root;
		TreeLinkNode nextQ = root.left;
		TreeLinkNode pt = nextQ;
		// under assumption of perfect tree
		while (nextQ != null) {
			// scan one level
			while (prevQ != null) {
				// pt is first element
				if (pt == nextQ) {
					prevQ.left.next = prevQ.right;
				} else {
					pt.next = prevQ.left;
					prevQ.left.next = prevQ.right;
				}

				if (prevQ.next != null) {
					pt = prevQ.right;
					prevQ = prevQ.next;
				} else {
					prevQ = nextQ;
					nextQ = prevQ.left;
					pt = nextQ;
					break;
				}
			}
		}
		return;
	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
