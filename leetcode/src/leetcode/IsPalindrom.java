package leetcode;

public class IsPalindrom {

	public static boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(x < 0) return false;
        int n = (int)(Math.log10(x)) + 1;//number of digits
        if(n == 1) { 
            return true;
        }
        
        int levels = (n + 1)/2;
        for(int lev = 1; lev <= levels; lev ++) {
            int head = (int)(x / Math.pow(10,n - 2 * lev + 1));
            if(x % 10 == head) {
                x = (int)((x - head * Math.pow(10,n - 2 * lev + 1)) / 10);
            } else {
                return false;
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		
		System.out.println(IsPalindrom.isPalindrome(11111));
		System.out.println(0-(-21474836));
		
	}
	
}
