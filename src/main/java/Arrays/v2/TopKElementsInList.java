package Arrays.v2;

import java.util.*;

public class TopKElementsInList {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 3, 2, 1, 1, 100};
        int k = 2;
        int[] topKFrequent = topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] frequencies = new List[nums.length + 1];
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < frequencies.length; i++) {
            frequencies[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            frequencies[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = frequencies.length - 1; i >= 0 && index < k; i--) {
            List<Integer> frequency = frequencies[i];
            for (Integer integer : frequency) {
                res[index] = integer;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }
        return nums;
    }
}
