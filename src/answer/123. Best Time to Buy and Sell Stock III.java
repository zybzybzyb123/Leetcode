class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0){
            return 0;
        }
        int[] num1 = new int[prices.length];
        int[] num2 = new int[prices.length];
        int Min = Integer.MAX_VALUE, Max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            Min = Math.min(Min, prices[i]);
            num1[i] = i > 0 ? Math.max(prices[i] - Min, num1[i - 1]) : 0;
        }
        int ans = 0;
        for (int i = prices.length - 1; i >= 0 ; i--) {
            Max = Math.max(Max, prices[i]);
            num2[i] = i < prices.length - 1 ? Math.max(Max - prices[i], num2[i + 1]) : 0;
            ans = Math.max(ans, i > 0 ? num1[i - 1] + num2[i] : num2[i]);
        }
        return ans;
    }
}