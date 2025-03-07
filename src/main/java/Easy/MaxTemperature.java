package Easy;

public class MaxTemperature {
    public static void main(String[] args) {
        int i = maxTemp(3, new int[]{2, -3, 5});
        System.out.println(i);

    }

    public static int maxTemp(int n, int[] changes) {
        int maxTemp = changes[0], currentTemp = changes[0];

        for (int i = 1; i < n; i++) {
            int change = changes[i];
            currentTemp = currentTemp + change;
            maxTemp = Math.max(currentTemp, maxTemp);
        }

        return maxTemp;
    }
}
