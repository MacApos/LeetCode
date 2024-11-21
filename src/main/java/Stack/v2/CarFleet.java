package Stack.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int carFleet = carFleet(target, position, speed);
        System.out.println(carFleet);
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        if (length <= 1) {
            return length;
        }
        int[][] cars = new int[length][];

        for (int i = 0; i < length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, Comparator.comparingInt(arr -> arr[0]));

        List<Double> fleets = new ArrayList<>(List.of(computeTime(cars[length - 1], target)));
        for (int i = length - 2; i >= 0; i--) {
            double time = computeTime(cars[i], target);
            if (time > fleets.get(fleets.size() - 1)) {
                fleets.add(time);
            }
        }

        return fleets.size();
    }

    public static double computeTime(int[] car, int target) {
        return (double) (target - car[0]) / car[1];
    }
}
