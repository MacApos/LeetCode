package Arrays.LeetCode.v1.Arrays;

/*
Greedy
Link1: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/4836121/simple-beginner-friendly-dry-run-greedy-approach-readable-sol-time-o-n-space-o-1-gits/
Link2: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/5816678/video-sell-a-stock-immediately/

DP
Link3: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/803206/python-js-java-go-c-o-n-by-dp-greedy-visualization-thinking-process/
Link4: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/1569081/java-simple-clean-dp-solutions-for-all-6-buy-sell-stock-questions-on-leetcode/
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2,  7};
        int greedyMaxProfit = greedyMaxProfit(prices2);
        System.out.println(greedyMaxProfit);

    }

    public static int greedyMaxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            int nextPrice = prices[i - 1];
            if (nextPrice < currPrice) {
                maxProfit += currPrice - nextPrice;
            }
        }
        return maxProfit;
    }
}
