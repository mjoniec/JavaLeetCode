package mediumArray;

public class _0122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int cash = 0;
        for(int i = 1; i<prices.length; i++){
            var profit = prices[i] - prices[i-1];
            if(profit > 0) cash+= profit;
        }
        return cash;
    }

    public void run() {
        System.out.println("_0122_BestTimeToBuyAndSellStockII");
        System.out.println("Expected: 7  Actual: " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Expected: 4  Actual: " + maxProfit(new int[]{1,2,3,4,5}));
        System.out.println("Expected: 0  Actual: " + maxProfit(new int[]{7,6,4,3,1}));
    }
}
