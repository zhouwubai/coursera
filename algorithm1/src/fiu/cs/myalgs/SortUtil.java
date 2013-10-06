package fiu.cs.myalgs;

import java.util.Comparator;

public class SortUtil {

	/************************************************
	 * Check if array is sorted - useful for debugging
	 ************************************************/
	public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
	public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

	public static boolean isSorted(Object[] a, Comparator c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
	public static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i-1])) return false;
        return true;
    }

   // print array to standard output
	public static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
	
	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
		System.out.println();
	}
    
	/************************************************
	 * Helper sorting functions
	 ************************************************/
	@SuppressWarnings("unchecked")
	public static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
	
	
	public static boolean less(Comparator c, Object v, Object w) {
		return (c.compare(v, w) < 0);
	}
	
	
	// exchange a[i] and a[j]
	public static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	
	/************************************************
	 * generate a random int array which has length N
	 ************************************************/
	public static Integer[] testArrayWithNoRepeat(int N) {
		Integer[] arr = new Integer[N];
		for(int i = 0; i < N; i ++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < N; i ++) {
			int rIdx = (int) (Math.random() * (N - i)) + i;
			exch(arr, i, rIdx);
		}
		return arr;
	}
	
	
	public static Integer[] testArrayWithRepeat(Integer N) {
		Integer[] arr = new Integer[N];
		
		for(int i = 0; i < N; i ++) {
			int num = (int) (Math.random() * N);
			arr[i] = num;
		}
		return arr;
	}
	
}
