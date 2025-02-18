package Arrays.LeetCode.v1.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int tooSlowMaxProfit = tooSlowMaxProfit(prices2);
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int tooSlowMaxProfit(int[] prices) {
        return recursion(0, 0, prices);
    }

    public static int recursion(int i, int maxProfit, int[] prices) {
        int currPrice = prices[i];
        for (int j = i + 1; j < prices.length; j++) {
            int diff = prices[j] - currPrice;
            maxProfit = Math.max(maxProfit, diff);
        }
        if (i < prices.length - 1) {
            maxProfit = Math.max(maxProfit, recursion(i + 1, maxProfit, prices));
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (min > price) {
                min = price;
            } else {
                maxProfit = Math.max(maxProfit, price - min);
            }
        }
        return maxProfit;
    }
}
