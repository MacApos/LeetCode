package Arrays.LeetCode.v1.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 3, 2, 2, 1, 1, 4};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {2, 3, 1, 1, 4};

        int myJump = myJumpV2(nums);
        int greedyJump = greedyJump(nums);
        System.out.println(greedyJump);
    }

    public static int myJumpV1(int[] nums) {
        int length = nums.length;
        int jumps = 0;
        int max = 0;
        int maxI = 0;
        for (int i = 0; i < length; i++) {
            jumps++;
            int range = i + nums[i];
            if (range >= length) return jumps;
            for (int j = i + 1; j < range + 1; j++) {
                if (j + nums[j] > max) {
                    max = nums[j];
                    maxI = j;
                }
            }
            i = maxI - 1;
        }

        return jumps;
    }

    public static int myJumpV2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int jumps = 1;
        int jumpPos = 0;
        int nextJumpPos = 0;
        for (int i = 1; i < length - 1; i++) {
            if (nextJumpPos + nums[nextJumpPos] < i + nums[i]) {
                nextJumpPos = i;
            }
            if (i < jumpPos + nums[jumpPos]) {
                continue;
            }
            jumps++;
            jumpPos = nextJumpPos;
        }

        return jumps;
    }

    public static int greedyJump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int currFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (currFarthest < i + nums[i]) {
                currFarthest = i + nums[i];
            }
            if (i == currEnd) {
                currEnd = currFarthest;
                jumps ++;
            }
        }

        return jumps;
    }
}
