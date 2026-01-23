package CodingBat.array;

import java.util.Arrays;

public class SquareUp {
    public static void main(String[] args) {
        int n = 3;
        int[] squareUp = squareUp(n);
        System.out.println(Arrays.toString(squareUp));
    }

    public static int[] squareUp(int n) {
        int[] result = new int[n * n];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                result[n * (n - j) - i] = i;
            }
        }
        return result;
    }

}
