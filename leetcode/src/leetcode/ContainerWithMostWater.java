package leetcode;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = height.length;
        int maxW = 0;
        int left = 0;
        int right = n - 1;
        int curH = 0;
        while(left < right) {
            curH ++;
            while(height[left] < curH && left < right) {
                left ++;
            }
            
            while(height[right] < curH && left < right) {
                right --;
            }
            
            maxW = Math.max(maxW, (right - left) * curH);
        }
        
        return maxW;
    }
	
}
