package fiu.cs.myalgs;

import java.util.Comparator;

public class Insertion {

	private Insertion() { }
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			for(int j = i; j > 0 && SortUtil.less(a[j], a[j-1]); j--) {
				SortUtil.exch(a, j, j-1);
			}
			assert SortUtil.isSorted(a, 0, i);
		}
		assert SortUtil.isSorted(a);
	}
	
	
	public static void sort(Object[] a, Comparator c) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for(int j = i; j > 0 && SortUtil.less(c, a[j], a[j-1]); j--) {
				SortUtil.exch(a, j, j-1);
			}
			assert SortUtil.isSorted(a, c, 0, i);
		}
		assert SortUtil.isSorted(a, c);
	}
    
    public static void main(String[] args) {
		
    	Integer[] arr = SortUtil.testArrayWithRepeat(20);
    	SortUtil.show(arr);
    	Insertion.sort(arr);
    	SortUtil.show(arr);
	}
	
}
