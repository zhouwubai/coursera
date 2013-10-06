package fiu.cs.myalgs;
/**
 * 
 * @author zhouwubai
 *
 */
public class WeightedQuickUnionUF {

	private int[] id;
	private int count;
	
	public WeightedQuickUnionUF(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		count = N;
	}
	
	public int count() {
		return count;
	}
	
	public void union(int p, int q) {
		
		int pid = find(p);
		int qid = find(q);
		if (pid == qid) return;
		id[pid] = qid;
		count --;
	}
	
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * find root of p. Here we use path compression, two path traverse.
	 * first: we find root of p.
	 * second: traverse from p to q, set all its id to root
	 * @param p
	 * @return
	 */
	int find(int p) {
		int root = p;
		while (root != id[root])
			root = id[root];
		
		int pt = p;
		while (p != root) {
			pt = id[p];
			id[p] = root;
			p = pt;
		}
			
		return root;
	}
	
	
	public static void main(String[] args) {
		
		WeightedQuickUnionUF wq = new WeightedQuickUnionUF(10);
		wq.connected(1, 5);
		System.out.println(wq.count);
		wq.union(1, 3);
		wq.union(2, 4);
		wq.union(1, 2);
		System.out.println(wq.count);
		System.out.println(wq.find(3));
		System.out.println(wq.connected(1, 4));
		
	}
	
}
