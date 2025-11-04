package Arrays.LeetCode.v1;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{6,6,6,6,7,7};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int majority = 0;
        for (int num : nums) {
            majority = hashMap.merge(num, 1, Integer::sum);
            if (majority > nums.length / 2) {
                return num;
            }
        }
        return majority;
    }
}
