package leetcode;

import java.util.ArrayList;

public class ClimbStairs {

	// this is very computationaly expensive
	public int climbStairsOld(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n <= 2) return n;
        return climbStairsOld(n-1) + climbStairsOld(n-2);
    }
	
	public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n <= 2) return n;
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for(int i = 2; i < n; i ++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n-1];
    }
	
	public static void main(String[] args) {
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(2);
		change(test);
		System.out.println(test.get(1));
		int[] arr = {1,3,3};
		
	}
	
	public static void change(ArrayList<Integer> a) {
		a.add(3);
	}
}
