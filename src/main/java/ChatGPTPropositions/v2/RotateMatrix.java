package ChatGPTPropositions.v2;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {4, 5},
                {7, 8}
        };
        int[][] rotateMatrix = rotateMatrix(matrix);
        Arrays.stream(matrix).forEach(ints -> System.out.println(Arrays.toString(ints)));
        Arrays.stream(rotateMatrix).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    /*
    1 2       7 4 1
    4 5   →   8 5 2
    7 8

    2-0, 1-0, 0-0
    2-1, 1-1, 0-1,


     */

    public static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[rows - i - 1][j];
            }
        }

        return result;
    }
}
