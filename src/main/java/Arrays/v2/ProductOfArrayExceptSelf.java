package Arrays.v2;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[] productExceptSelf = productExceptSelf(nums);
        System.out.println(Arrays.toString(productExceptSelf));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] postfix = new int[len];
        int[] result = new int[len];

        prefix[0] = 1;
        postfix[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }

    public static int[] optimalProductExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int product = 1;
        for (int i = len - 2; i >= 0; i--) {
            product = product * nums[i + 1];
            result[i] = product * result[i];
        }

        return result;
    }
}
