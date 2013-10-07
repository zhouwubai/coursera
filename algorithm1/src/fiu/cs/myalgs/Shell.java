package fiu.cs.myalgs;

public class Shell {

	public static void sort(Comparable a[]) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				/**
				 * this is same as : sort a[i:h:N] in one loop. following code
				 * distribute this one loop into multiple loop.
				 */
				for (int j = i; j >= h && SortUtil.less(a[j], a[j - h]); j -= h) {
					SortUtil.exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	public static void main(String[] args) {

		Integer[] arr = SortUtil.testArrayWithNoRepeat(20);
		SortUtil.show(arr);
		Shell.sort(arr);
		SortUtil.show(arr);

	}

}
