package fiu.cs.myalgs;

public class Bubble {

	public static void sort(Comparable a[]) {
		int N = a.length;
		for(int i = 0; i < N; i ++) {
			boolean flag = false;
			for(int j = N - 1; j > i; j --) {
				if(SortUtil.less(a[j], a[j-1])) {
					SortUtil.exch(a, j, j-1);
					flag = true;
				}
			}
			assert SortUtil.isSorted(a, 0, i);
			if(!flag)
				break;
		}
		assert SortUtil.isSorted(a);
	}
	
	
	public static void main(String[] args) {
		
		Integer[] arr = SortUtil.testArrayWithRepeat(20);
    	SortUtil.show(arr);
    	Bubble.sort(arr);
    	SortUtil.show(arr);
		
	}
	
}
