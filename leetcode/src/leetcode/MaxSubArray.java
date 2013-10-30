package leetcode;

public class MaxSubArray {

	public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return findMaxSubarray(A,0,A.length - 1);
    }
    
    
    public int findMaxSubarray(int[] A, int low, int high) {
        
        if(low == high) {
            return A[low];
        }
        int mid = (low + high) / 2;
        int left = findMaxSubarray(A,low,mid);
        int crossing = findMaxCrossingSubarray(A,low,mid,high);
        int right = findMaxSubarray(A,mid+1,high);
        if(left >= crossing && left >= right) {
            return left;
        }else if(right >= left && right >= crossing) {
            return right;
        }else {
            return crossing;
        }
        
    }
    
    public int findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if(sum > leftSum) {
                leftSum = sum;
            }
        }
        
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1; i <= high; i++) {
            sum = sum + A[i];
            if(sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
	
}
