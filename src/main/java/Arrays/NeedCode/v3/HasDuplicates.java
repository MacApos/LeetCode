package Arrays.NeedCode.v3;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicates {
    public static void main(String[] args) {

    }

    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            boolean add = integers.add(num);
            if (!add) return true;
        }
        return false;
    }
}
