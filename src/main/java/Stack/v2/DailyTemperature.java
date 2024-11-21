package Stack.v2;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {30, 38, 30, 36, 35, 40, 28};
        int[] stackDailyTemperatures = stackDailyTemperatures(temperatures);
        System.out.println(Arrays.toString(stackDailyTemperatures));
    }


    public static int[] stackDailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(new int[]{0, temperatures[0]});

        for (int i = 1; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && currTemp > stack.peek()[1]) {
                int[] pop = stack.pop();
                res[pop[0]] = i - pop[0];
            }
            stack.push(new int[]{i, currTemp});
        }

        return res;
    }
}
