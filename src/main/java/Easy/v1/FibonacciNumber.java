package Easy.v1;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(1)));
        System.out.println(fibSum(4));
    }

    public static int fibSum(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0, sum = 1;
        for (int i = 1; i < n; i++) {
            int x = sum;
            sum += prev;
            prev = x;
        }
        return sum;
    }

    public static int[] fib(int n) {
        int[] sequence = new int[n];
        if (n > 1) {
            sequence[0] = 0;
        }
        if (n > 2) {
            sequence[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }

}
