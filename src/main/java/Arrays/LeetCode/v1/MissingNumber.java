package Arrays.LeetCode.v1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums2 = new int[]{0,1};
        int missingNumberV1 = missingNumberV1(nums2);
        int missingNumberV2 = missingNumberV2(nums2);
        int missingNumberV3 = missingNumberV3(nums);
        System.out.println(missingNumberV1);
    }

    public static int missingNumberV1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, 0);
        }

        int length = nums.length;
        Set<Integer> set = hashMap.keySet();
        int index = 0;
        for (Integer i : set) {
            if (index != i) {
                return index;
            }
            index++;
        }

        return length;
    }

    public static int missingNumberV2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return length;
    }

    public static int missingNumberV3(int[] nums) {
        int length = nums.length;
        int givenSum = 0, properSum = 0;
        for (int i = 0; i < length; i++) {
            givenSum += nums[i];
            properSum += i;
        }
        return properSum + length - givenSum;
    }

}
