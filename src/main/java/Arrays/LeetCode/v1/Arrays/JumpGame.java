package Arrays.LeetCode.v1.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {3, 0, 8, 2, 0, 0, 1};
        int[] nums4 = {2, 0};
        boolean gasCanJump = gasCanJump(nums);
        boolean canJump = canJump(nums2);
        boolean recursionCanJump = recursionCanJump(nums2);
        boolean memoizationCanJump = memoizationCanJump(nums2);
        boolean tabulationCanJump = tabulationCanJump(nums2);
        System.out.println(tabulationCanJump);
    }

    public static boolean gasCanJump(int[] nums) {
        int gas = 0;
        for (int num : nums) {
            if (gas < 0) {
                return false;
            } else if (num > gas) {
                gas = num;
            }
            gas--;
        }
        return true;
    }

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int goal = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    public static boolean recursionCanJump(int[] nums) {
        return recursion(nums, 0);

    }

    public static boolean recursion(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return true;
        }

        if (nums[idx] == 0) {
            return false;
        }

        int range = idx + nums[idx];
        for (int i = idx + 1; i < range + 1; i++) {
            int num = nums[idx];
            if (i < nums.length && recursion(nums, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean memoizationCanJump(int[] nums) {
        boolean[] dp = new boolean[nums.length - 1];
        return memoization(nums, 0, dp);

    }

    public static boolean memoization(int[] nums, int idx, boolean[] dp) {
        int num = nums[idx];
        if (idx == nums.length - 1) {
            return true;
        }

        if (num == 0) {
            return false;
        }

        if (dp[idx]) {
            return true;
        }

        int range = idx + num;
        for (int i = idx + 1; i < range + 1; i++) {
            if (i < nums.length && memoization(nums, i, dp)) {
                dp[idx] = true;
                return true;
            }
        }

        dp[idx] = false;
        return false;
    }

    public static boolean tabulationCanJump(int[] nums) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};

        int length = nums.length;
        boolean[] dp = new boolean[length];
        dp[length - 1] = true;

        for (int idx = length - 2; idx >= 0; idx--) {
            if (nums[idx] == 0) {
                dp[idx] = false;
                continue;
            }

            int flag = 0;
            int range = idx + nums[idx];
            for (int i = idx + 1; i < range + 1; i++) {
                if (i < length && dp[i]) {
                    dp[i] = true;
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                continue;
            }

            dp[idx] = false;
        }

        return dp[0];
    }

    public static boolean KadaneAlgorithmCanJump(int[] nums) {
        int range = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (range < i) {
                return false;
            }
            if (range < i + nums[i]) {
                range = i + nums[i];
            }
        }
        return true;
    }
}
