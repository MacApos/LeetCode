package Intervals.v1;

/*
    https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
    https://leetcode.com/problems/summary-ranges/solutions/6116130/0-ms-runtime-beats-100-user-code-idea-algorithm-solving-step/?envType=study-plan-v2&envId=top-interview-150
*/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> strings = summaryRanges(nums);
        System.out.println(strings);
    }

    public static List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        ArrayList<String> result = new ArrayList<>();

        if (length == 0) {
            return result;
        }

        int start = nums[0];
        for (int i = 1; i <= length; i++) {
            if (i == length || nums[i] - nums[i - 1] != 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                if (i < length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }


    public static List<String> summaryRanges2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return List.of();
        }

        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>(List.of(nums[0])));
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            ArrayList<Integer> integers = test.get(test.size() - 1);
            if (num - integers.get(integers.size() - 1) == 1) {
                integers.add(num);
            } else {
                test.add(new ArrayList<>(List.of(num)));
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<Integer> integers : test) {
            if (integers.size() < 2) {
                result.add(integers.get(0) + "");
            } else {
                result.add(integers.get(0) + "->" + integers.get(integers.size() - 1));
            }
        }

        return result;
    }
}
