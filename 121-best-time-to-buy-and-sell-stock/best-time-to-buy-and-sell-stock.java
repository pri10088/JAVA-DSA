class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxP = 0;
        for(int price : prices){
            if(minPrice > price){
                minPrice = price;
            }else{
                maxP = Math.max(maxP, price - minPrice);

            }
           
            
        }
         return maxP;
        
    }
}