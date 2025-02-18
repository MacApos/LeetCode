package Arrays.NeedCode.v3;

import java.util.TreeMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        int res = 0;
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                Integer smallerNum = hashMap.getOrDefault(num - 1, 0);
                Integer biggerNum = hashMap.getOrDefault(num + 1, 0);

                hashMap.put(num, smallerNum + biggerNum + 1);
                Integer sum = hashMap.get(num);

                hashMap.put(num - smallerNum, sum);
                hashMap.put(num + smallerNum, sum);

                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
