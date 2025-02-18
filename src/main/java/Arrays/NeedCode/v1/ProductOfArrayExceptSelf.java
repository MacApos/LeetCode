package Arrays.NeedCode.v1;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
        int[] myProductExceptSelf = myProductExceptSelf(input);
        int[] prefixAndSuffix = prefixAndPostfix(input);
        int[] optimalPrefixAndPostfix = optimalPrefixAndPostfix(input);
        System.out.println(Arrays.toString(optimalPrefixAndPostfix));
    }

    public static int[] myProductExceptSelf(int[] nums) {
        int length = nums.length;
        int[] numbers = new int[length * length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nums[i % length];
        }

        for (int i = 0; i < nums.length; i++) {
            numbers[i * (length + 1)] = 1;
        }

        int i = 0;
        int[] result = new int[length];
        while (i < length) {
            int j = length * i + 1;
            int product = numbers[j - 1];
            while (j < length * (i + 1)) {
                product = product * numbers[j];
                j++;
            }
            result[i] = product;
            i++;
        }
        return result;
    }

    public static int[] prefixAndPostfix(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] postfix = new int[length];
        int[] res = new int[length];

        prefix[0] = 1;
        postfix[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = prefix[i] * postfix[i];
        }

        return res;
    }

    public static int[] optimalPrefixAndPostfix(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }

        return res;
    }

}