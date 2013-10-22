package leetcode;

public class MaxProfit {

	public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int profit = 0;
        int diff = 0;
        for(int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i-1];
            if(diff > 0) {
                profit += diff;
            }
        }
        
        return profit;
    }
	
}
