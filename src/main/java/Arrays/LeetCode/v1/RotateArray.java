package Arrays.LeetCode.v1;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums1, k1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void rotateV0(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        int[] ints = Arrays.copyOf(nums, length);
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i < k) {
                nums[k - i - 1] = ints[length - i - 1];
            } else {
                nums[i] = ints[j];
                j++;
            }
        }
    }

    public static void rotateV1(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        for (int i = 0; i < k; i++) {
            int j = 1;
            int tmp = nums[j - 1];
            while (j < length) {
                int tmp2 = tmp;
                tmp = nums[j];
                nums[j] = tmp2;
                j++;
            }
            nums[0] = tmp;
        }

    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        arrangeElements(nums, 0, length-1);
        arrangeElements(nums, 0, k-1);
        arrangeElements(nums, k, length-1);
    }

    public static void arrangeElements(int[] nums, int start, int end){
        while (start < end) {
            int numStart = nums[start];
            int numEnd = nums[end];

            nums[start] = numEnd;
            nums[end] = numStart;

            end--;
            start++;
        }

    }

}
