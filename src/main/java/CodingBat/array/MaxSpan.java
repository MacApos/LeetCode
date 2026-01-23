package CodingBat.array;

import java.util.HashMap;

public class MaxSpan {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3, 4, 5, 6, 7, 8, 8};
        int maxSpan = maxSpan(nums);
        System.out.println(maxSpan);
    }

    public static int maxSpan(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashMap.putIfAbsent(num, i);
            max = Math.max(max, i - hashMap.get(num) + 1);
        }
        return max;
    }

}
