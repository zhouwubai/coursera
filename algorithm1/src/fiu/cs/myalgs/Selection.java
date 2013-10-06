package fiu.cs.myalgs;

public class Selection {

	private Selection() { }
	
	public static void sort(Comparable a[]) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int minIdx = i;
			for(int j = i; j < N; j ++) {
				if(SortUtil.less(a[j], a[minIdx])) {
					minIdx = j;
				}
			}
			SortUtil.exch(a, i, minIdx);
			assert SortUtil.isSorted(a, 0, i);
		}
		assert SortUtil.isSorted(a);
	}
	
	
	
	
}
