package Stack.v1;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {30, 41, 30, 36, 35, 40, 28};
        int[] temperatures2 = {30,40,50,60};
        int[] stackDailyTemperatures = stackDailyTemperatures(temperatures);
        int[] bruteForceDailyTemperatures = bruteForceDailyTemperatures(temperatures2);
        System.out.println(Arrays.toString(bruteForceDailyTemperatures));
    }

    public static int[] bruteForceDailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 0; i < length - 1; i++) {
//            for (int k = i + 1; k < length ; k++) {
//                if (temperatures[i] < temperatures[k]) {
//                    res[i] = k - i;
//                    break;
//                }
//            }
//
            int j = i + 1;
            int count = 1;
            while (j < length) {
                if (temperatures[i] < temperatures[j]) {
                    break;
                }
                count++;
                j++;
            }
            res[i] = j == length ? 0 : count;
        }
        return res;
    }

    public static int[] stackDailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && currTemp > stack.peek()[1]) {
                int[] prevTemp = stack.pop();
                int prevTempIdx = prevTemp[0];
                res[prevTempIdx] = i - prevTempIdx;
            }
            stack.push(new int[]{i, currTemp});
        }
        return res;
    }
}
