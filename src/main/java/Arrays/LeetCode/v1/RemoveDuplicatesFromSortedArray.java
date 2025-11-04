package Arrays.LeetCode.v1;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums2 = {1,1,2};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {

        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] != nums[i]) {
                idx++;
                nums[idx] = nums[i];

            }
        }

        return idx+1;
    }
}
