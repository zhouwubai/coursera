package leetcode;

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
		
		int[] test = {1,2,3,4};
		int i = 1;
		System.out.println(i++);
		
	}
}
