package Arrays.LeetCode.v1;

import java.util.ArrayList;
import java.util.Arrays;

public class MergedSortedArray {
    public static int[] nums1;
    public static int m;
    public static int[] nums2;
    public static int n;

    public static void main(String[] args) {
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        m = 3;
        nums2 = new int[]{2, 5, 6};
        n = 3;

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;

        nums1 = new int[]{2, 0};
        m = 1;
        nums2 = new int[]{1};
        n = 1;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];

        int i = 0;
        int j = 0;
        while (m != i || n != j) {
            if (n == j || m != i && nums1[i] <= nums2[j]) {
                result[i + j] = nums1[i];
                i++;
            }
            else {
                result[i + j] = nums2[j];
                j++;
            }
        }

        for (int k = 0; k < nums1.length; k++) {
            nums1[k] = result[k];
        }
    }
}
