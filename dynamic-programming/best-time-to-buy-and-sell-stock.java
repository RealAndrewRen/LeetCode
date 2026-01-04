class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i; j < prices.length; j++){
                if (prices[j] - prices[i] > result){
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }
}