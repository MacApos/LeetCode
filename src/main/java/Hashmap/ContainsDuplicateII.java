package Hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        boolean containsNearbyDuplicate = containsNearbyDuplicateV2(new int[]{1, 0, 1, 1}, 1);
        System.out.println(containsNearbyDuplicate);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = hashMap.get(nums[i]);
            if (j != null && Math.abs(i - j) <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicateV2(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i])) {
                return true;
            }
//            If i >= k any duplicate will fulfill the condition
            if (i >= k) {
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }

}
