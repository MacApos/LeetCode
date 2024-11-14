package TwoPointers.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 2, 3};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0, 0};
        int[] nums4 = {-3, -3, -3, -3, 0, 1, 2, 3};
        List<List<Integer>> threeSum = threeSum(nums4);
        List<List<Integer>> myThreeSum = myThreeSum(nums4);
        System.out.println(threeSum);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    do {
                        start++;
                    } while (nums[start - 1] == nums[start] && start < end);
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> myThreeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<String> strings = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int first = nums[i] * -1;

            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == first) {
                    List<String> list = new ArrayList<>();
                    List<Integer> num = new ArrayList<>();
                    for (int j : new int[]{nums[i], nums[start], nums[end]}) {
                        list.add(String.valueOf(j));
                        num.add(j);
                    }
                    String join = String.join("-", list);
                    if (strings.contains(join)) {
                        start++;
                    } else {
                        strings.add(join);
                        result.add(num);
                        break;
                    }
                } else if (sum < first) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
