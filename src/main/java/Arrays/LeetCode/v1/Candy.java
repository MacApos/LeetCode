package Arrays.LeetCode.v1;
/*
  https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
  https://leetcode.com/problems/candy/solutions/2234434/c-o-n-time-o-1-space-full-explanation/?envType=study-plan-v2&envId=top-interview-150
*/

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        int[] ratings2 = {1, 3, 2, 2, 1};
        int[] ratings3 = {1, 2, 87, 87, 87, 2, 1};
//        int candy = candy(ratings3);
        int candyV2 = candyV2(ratings3);
//        System.out.println(candy);
        System.out.println(candyV2);
    }

    public static int candyV2(int[] ratings) {
        int result = 0;
        int length = ratings.length;

        int[] candies = new int[length];
        Arrays.fill(candies, 1);
        candies[0] = 1;
        for (int i = 1; i < length; i++) {
            candies[i] = 1;
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                int prevCandy = candies[i - 1];
                int currCandy = candies[i];
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
            result += candies[i - 1];
        }

        return result + candies[length - 1];
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int cnt = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            cnt += candies[i - 1];
        }
        return cnt + candies[n - 1];
    }
}
