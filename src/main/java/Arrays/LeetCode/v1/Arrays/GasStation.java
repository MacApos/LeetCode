package Arrays.LeetCode.v1.Arrays;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int bruteForceCanCompleteCircuit = bruteForceCanCompleteCircuit(gas, cost);
        int canCompleteCircuit = canCompleteCircuit(gas, cost);
        System.out.println(canCompleteCircuit);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();
        
        if (totalCost > totalGas) {
            return -1;
        }

        int start = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += (gas[i] - cost[i]);
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }

        return start;

    }

    public static int bruteForceCanCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int j = i;

            int totalGas = 0;
            int stations = 0;
            while (stations < length) {
                totalGas += (gas[j % length] - cost[j % length]);
                if (totalGas < 0) {
                    break;
                }
                stations++;
                j++;
            }
            if (stations == length) {
                return i;
            }
        }
        return -1;
    }
}
