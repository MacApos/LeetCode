package Arrays.NeedCode.v1;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/
 */

import java.util.*;

public class TopKElementsInList {
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{2, 2, 3, 3, 3, 1, 1}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();

//        ArrayList of ArrayLists - initial array can have at most this many unique values
        List<Integer>[] frequencies = new ArrayList[nums.length];
        for (int i = 0; i <= nums.length-1; i++) {
            numsHashMap.put(nums[i], numsHashMap.getOrDefault(nums[i], 0) + 1);
            frequencies[i] = new ArrayList<>();
        }

//        add numbers to array corresponding to frequency of a number
        for (Map.Entry<Integer, Integer> entry : numsHashMap.entrySet()) {
            Integer num = entry.getKey();
            Integer frequency = entry.getValue();
            frequencies[frequency-1].add(num);
        }

        StringBuilder stringBuilder = new StringBuilder("count\tvalues\n");
        int index = 1;
        System.out.println(Arrays.toString(frequencies));
        for (List<Integer> frequency : frequencies) {
            System.out.println(frequency);
            stringBuilder.append(index).append("\t").append(frequency).append("\n");
            index++;
        }
        System.out.println(stringBuilder);

        int idx = 0;
        int[] result = new int[k];
        for (List<Integer> frequency : frequencies) {
            for (Integer number : frequency) {
                result[idx] = number;
                idx++;
                if (idx == k) {
                    return result;
                }
            }
        }
//
//        List<Integer> list = frequencies.stream().flatMap(Collection::stream).toList();
//        for (int i = 0; i < result.length; i++) {
//            result[i] = list.get(list.size() - i - 1);
//        }
//


        return result;
    }
}
