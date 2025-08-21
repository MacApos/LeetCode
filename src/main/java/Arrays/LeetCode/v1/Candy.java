package Arrays.LeetCode.v1;
/*
  https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
  https://leetcode.com/problems/candy/solutions/2234434/c-o-n-time-o-1-space-full-explanation/?envType=study-plan-v2&envId=top-interview-150
*/

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        int[] ratings2 = {1, 3, 2, 2, 1};
        int[] ratings3 = {1,2,87,87,87,2,1};
        int candy = candy(ratings3);
        System.out.println(candy);
    }

    public static int candy(int[] ratings) {
        int result = ratings.length;
        if (result < 2) {
            return result;
        }
        int prevChild = ratings[0];
        boolean previousChildGotCandy = false;
        for (int i = 1; i < ratings.length; i++) {
            if (prevChild < ratings[i]) {
                previousChildGotCandy = true;
                result++;
            } else if (prevChild > ratings[i] && !previousChildGotCandy) {
                result++;
            } else if (previousChildGotCandy) {
                previousChildGotCandy = false;
            }
            prevChild = ratings[i];
        }
        return result;
    }
}
