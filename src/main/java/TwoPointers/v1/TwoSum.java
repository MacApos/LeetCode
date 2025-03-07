package TwoPointers.v1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 3;

        int[] nums2 = {2, 7, 11, 15};
        int target2 = 9;

        int[] bruteForceTwoSum = bruteForceTwoSum(nums, target);
        int[] sortedOrderTwoSum = sortedOrderTwoSum(nums, target);

        int[] hashTableTwoSum = hashTableTwoSum(nums2, target2);
        System.out.println(Arrays.toString(hashTableTwoSum));
    }

    public static int[] bruteForceTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static int[] sortedOrderTwoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int product = nums[start] + nums[end];
            if (product == target) {
                return new int[]{start, end};
            } else if (product < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }

    public static int[] hashTableTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int res = target - num;
            if (hashMap.containsKey(res)) {
                return new int[]{hashMap.get(res), i};
            }
            hashMap.put(num, i);
        }

        return new int[]{};
    }

}
