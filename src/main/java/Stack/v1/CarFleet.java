package Stack.v1;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int target2 = 10;
        int[] position2 = {3, 5, 7};
        int[] speed2 = {3, 2, 1};
        int target3 = 100;
        int[] position3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};
        int target4 = 10;
        int[] position4 = {3};
        int[] speed4 = {3};
        int carFleet = carFleet(target4, position4, speed4);
        System.out.println(carFleet);
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        if (position.length <= 1) {
            return position.length;
        }

        int[][] combinedArr = new int[position.length][2];
        for (int i = 0; i < combinedArr.length; i++) {
            combinedArr[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(combinedArr, (arr1, arr2) -> {
            Integer i1 = arr1[0];
            Integer i2 = arr2[0];
            return i2.compareTo(i1);
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(combinedArr[0]);
        double peekTimeToTarget = computeTimeToTarget(stack.peek(), target);

        for (int i = 1; i < combinedArr.length; i++) {
            double currTimeToTarget = computeTimeToTarget(combinedArr[i], target);

            if (currTimeToTarget > peekTimeToTarget) {
                stack.push(combinedArr[i]);
                peekTimeToTarget = computeTimeToTarget(stack.peek(), target);
            }
        }
        return stack.size();
    }

    public static double computeTimeToTarget(int[] arr, int target) {
        return (target - (double) arr[0]) / arr[1];
    }
}
