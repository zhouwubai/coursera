package leetcode;

public class Reverse {

	public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int imgX = x;
        int rtn = 0;
        while(imgX != 0) {
            rtn = 10 * rtn + (imgX % 10);
            imgX /= 10;
        }
        
        return rtn;
    }
	
}
