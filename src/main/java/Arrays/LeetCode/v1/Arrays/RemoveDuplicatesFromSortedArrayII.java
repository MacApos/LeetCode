package Arrays.LeetCode.v1.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums3 = {1, 1, 1, 1, 3, 3};
        int[] nums4 = {1, 1, 1, 1, 2, 2, 3};
        int[] nums5 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums6 = {1, 1, 1};

        int[] test = nums2;
        int[] copy = Arrays.copyOf(test, test.length);
        int optimalRemoveDuplicates = optimalRemoveDuplicates(test);
        System.out.println(optimalRemoveDuplicates);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(Arrays.stream(test).limit(optimalRemoveDuplicates).toArray()));

    }

    public static int myRemoveDuplicates(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int j = 0;
        int k = 0;

        for (int i = 0; j < length; i++) {
            int num = nums[j];
            int get = hashMap.getOrDefault(num, 0);
            if (get < 2) {
                hashMap.put(num, get + 1);
            } else {
                while ( j < length && nums[j] == nums[j - 1]) {
                    j++;
                    if(j == length) return k;
                }
                hashMap.put(nums[j], 1);
            }
            nums[i] = nums[j];
            k++;
            j++;
        }

        return k;
    }

    public static int optimalRemoveDuplicates(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return length;
        }

        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]!=nums[k]){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
