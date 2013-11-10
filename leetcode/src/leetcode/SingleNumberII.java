package leetcode;

public class SingleNumberII {

	public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // get idea from https://github.com/yxjiang
        
        int once = 0, twice = 0, third = 0;
        for(int val : A) {
            twice |= once & val;
            once ^= val;
            
            third = once & twice;
            twice &= ~third;
            once &= ~third;
        }
        
        return once; //seems not right when return twice or third
    }
	
}
