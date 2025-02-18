package Arrays.LeetCode.v1.Arrays;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int bruteForceCanCompleteCircuit = bruteForceCanCompleteCircuit(gas, cost);
        System.out.println(bruteForceCanCompleteCircuit);
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
