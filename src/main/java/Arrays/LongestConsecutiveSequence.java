package Arrays;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {2, 20, 4, 10, 12, 11, 13, 14, 3, 5, 4};
        int[] nums2 = {0, 3, 2, 5, 4, 6, 1, 1};
        int[] nums3 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        int[] nums4 = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
        int[] nums5 = {7, -9, 3, -6, 3, 5, 3, 6, -2, -5, 8, 6, -4, -6, -4, -4, 5, -9, 2, 7, 0, 0};

        System.out.println(myLongestConsecutive(nums5));
    }

    public static int myLongestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);

        int result = 1;
        int memory = 0;

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            if (curr == prev) {
                continue;
            }
            if (curr - 1 == prev) {
                result++;
            } else if (result >= memory) {
                memory = result;
                result = 1;
            } else {
                result = 1;
            }
        }

        return Math.max(result, memory);
    }

    public static int longestConsecutive(int[] nums) {
        int result = 0;

        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        

        for (int num : nums) {
//            hashMap.put(num, )
        }
        return 0;
    }
}
