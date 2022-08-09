package easyArray;

public class _0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        int minPrice = prices[0];

        for(int price : prices){
            if(price<minPrice){
                minPrice = price;
            }
            else if(bestProfit < price - minPrice){
                bestProfit = price - minPrice;
            }
        }

        return bestProfit;
    }

    public void run() {
        System.out.println("_0121_BestTimeToBuyAndSellStock: ");
        System.out.println("Expected: 5 Actual: " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Expected: 0 Actual: " + maxProfit(new int[]{7,6,4,3,1}));
    }
}
