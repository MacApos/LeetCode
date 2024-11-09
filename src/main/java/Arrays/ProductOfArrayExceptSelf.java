package Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(input));
        int[] productExceptSelf = productExceptSelf(input);
        int[] prefixAndSuffix = prefixAndSuffix(input);
//        System.out.println(Arrays.toString(prefixAndSuffix));
    }

    public static int[] productExceptSelf(int[] nums) {
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

    public static int[] prefixAndSuffix(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        prefix[0] = 1;
        suffix[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
                System.out.println(prefix[i]);
        }

        System.out.println(Arrays.toString(prefix));

        return nums;
    }

}