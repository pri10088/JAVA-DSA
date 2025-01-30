class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Track the minimum price seen so far
        int maxProfit = 0; // Track the maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update minPrice if a new lower price is found
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Calculate max profit
            }
        }
        return maxProfit;
    }
}
