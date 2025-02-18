package Arrays.NeedCode.v1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {5, 2, 20, 4, 10, 3, 4};
        int bruteForceLongestConsecutive = bruteForceLongestConsecutive(nums);
        int sortingLongestConsecutive = sortingLongestConsecutive(nums);
        int hashSetLongestConsecutive = hashSetLongestConsecutive(nums);
        int hashMapLongestConsecutive = hashMapLongestConsecutive(nums);
        int leetCodeLongestConsecutive = leetCodeLongestConsecutive(nums);
        System.out.println(leetCodeLongestConsecutive);
    }

    public static int bruteForceLongestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        int res = 0;
        for (int num : nums) {
            int currentNum = num;
            int sequenceLength = 0;
            while (hashSet.contains(currentNum)) {
                currentNum++;
                sequenceLength++;
            }
            res = Math.max(res, sequenceLength);
        }

        return res;
    }

    public static int sortingLongestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res = 0, i = 0, sequenceLength = 0, currentNum = nums[0];

        while (i < nums.length) {
            if (currentNum != nums[i]) {
                currentNum = nums[i];
                sequenceLength = 0;
            }

//            while instead of if is for duplicates
            while (i < nums.length && currentNum == nums[i]) {
                i++;
            }
            sequenceLength++;
            currentNum++;
            res = Math.max(res, sequenceLength);
        }

        return res;
    }

    public static int hashSetLongestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!hashSet.contains(num - 1)) {
                int sequenceLength = 1;
                while (hashSet.contains(num + sequenceLength)) {
                    sequenceLength++;
                }
                res = Math.max(res, sequenceLength);
            }
        }

        return res;
    }

    //    I don't get it
    public static int hashMapLongestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int res = 1;
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.getOrDefault(num - 1, 0)
                        + hashMap.getOrDefault(num + 1, 0) + 1);
                hashMap.put(num - hashMap.getOrDefault(num - 1, 0),
                        hashMap.get(num));

                hashMap.put(num + hashMap.getOrDefault(num + 1, 0),
                        hashMap.get(num));
                res = Math.max(res, hashMap.get(num));
            }
        }

        return res;
    }

    public static int leetCodeLongestConsecutive(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        Arrays.sort(nums);

        int res = 1;
        int sequenceLength = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                sequenceLength++;
                res = Math.max(res, sequenceLength);
            } else if (nums[i - 1] < nums[i]) {
                sequenceLength = 1;
            }
        }
        return res;
    }

}
