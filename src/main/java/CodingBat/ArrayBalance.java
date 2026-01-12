package CodingBat;

public class ArrayBalance {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 0, 1, -1, 10};
        int[] nums2 = new int[]{1, 1, 1, 2, 1};
        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{2, 1, 1, 1, 4};
        int[] nums5 = new int[]{1, 1, 1, 1, 1, 1};
        int[] nums6 = {2, 1, 1, 2, 1};
        boolean canBalance = canBalance(nums5);
        System.out.println(canBalance);
    }

    public static boolean canBalance(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;
        int leftSum = nums[start];
        int rightSum = nums[end];

        while (start < end - 1) {
            if (leftSum < rightSum) {
                start++;
                leftSum += nums[start];
            } else if (leftSum > rightSum) {
                end--;
                rightSum += nums[end];
            } else {
                start++;
                leftSum += nums[start];
                if (start < end - 1) {
                    end--;
                    rightSum += nums[end];
                }
            }
        }

        return leftSum == rightSum;
    }
}
