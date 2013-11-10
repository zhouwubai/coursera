package leetcode;

public class PlusOne {

	public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int carry = 1;// set to 1 for less code
        int n = digits.length;
        for(int i = n - 1; i >= 0; i --) {
            digits[i] = digits[i] + carry;
            if(digits[i] >= 10) {
                carry = 1;
                digits[i] %= 10;
            } else {
                return digits;
            }
        }
        
        // if program comes to here, it means num = "999.."
        int[] newDigits = new int[n+1];
        newDigits[0] = carry;
        for(int i = 1; i < n + 1; i ++) {
            newDigits[i] = digits[i-1];
        }
        return newDigits;
    }
	
}
