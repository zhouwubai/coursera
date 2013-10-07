package fiu.cs.myalgs;

public class Merge {

	private Merge() { }
	
	
	
	public static void topDownSort(Comparable[] a) {
		
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		topDownSort(a, aux, 0, N - 1);
		
	}
	
	
	public static void topUpSort(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int step = 1; step < N; step = 2 * step) {
			/**
			 * Here N - step to just prevent we sort 
			 * some part that already being sorted.
			 */
			for (int i = 0; i < N - step; i += 2 * step) {
				int lo = i;
				int mid = i + step - 1;
				int hi = Math.min(i + step + step -1, N - 1);
				merge(a, aux, lo, mid, hi);
			}
		}
	}
	
	
	private  static void topDownSort(Comparable[] a, 
			Comparable[] aux, int lo, int hi) {
		
		if (lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		topDownSort(a, aux, lo, mid);
		topDownSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
		
	}
	
	
	private static void merge(Comparable a[],
			Comparable aux[], int lo, int mid, int hi) {
		assert SortUtil.isSorted(a, lo, mid);
		assert SortUtil.isSorted(a, mid + 1, hi);
		
		for(int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		
		int pt1 = lo, pt2 = mid + 1;
		for(int i = lo; i <= hi; i++) {
			if(pt1 > mid)  								{a[i] = aux[pt2++];}
			else if(pt2 > hi) 							{a[i] = aux[pt1++];}
			else if(SortUtil.less(aux[pt2], aux[pt1])) 	{a[i] = aux[pt2++];}
			else 										{a[i] = aux[pt1++];}
		}
		
	}
	
	
	public static void main(String[] args) {

		Integer[] arr = SortUtil.testArrayWithRepeat(20);
		SortUtil.show(arr);
		Merge.topUpSort(arr);
		SortUtil.show(arr);

	}
	
	
}
