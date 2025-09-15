package Arrays.NeedCode.v4.ArraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicates {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4,5,5,5}));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
