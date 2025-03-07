package Arrays.NeedCode.v3;

import java.util.ArrayList;
import java.util.HashMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        topKFrequent(nums, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();

        for (int num : nums) {
            numsHashMap.put(num, numsHashMap.getOrDefault(num, 0) + 1);
        }

        return result;
    }
}
