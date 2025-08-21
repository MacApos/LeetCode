package Easy.v1;
import java.util.Arrays;

public class LeetCode1 {
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

//    public static int[] hashSolution(int[] nums, int target){
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(i, nums[i]);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int i1 = target - nums[i];
//            Optional<Integer> first = map.values().stream().filter(num -> num == target - nums[i]).findFirst();
//            if(map.containsValue(target-nums[i])){
//                return [i, map]
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(solution));
    }
}
