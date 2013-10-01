package leetcode;

public class TwoSum {
	
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] idx = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int num1 = numbers[i];
            idx[0] = i + 1;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] != target - num1) continue;
                else {
                    idx[1] = j + 1;
                    return idx;
                }
            }
        }
        
        return idx;
        
    }
    
    public static void main(String[] args) {
		
    	int[] arr = {5,75,25};
    	TwoSum ts = new TwoSum();
    	int[] rtn = ts.twoSum(arr, 100);
    	System.out.println(rtn[0] + rtn[1]);
	}
	
}
