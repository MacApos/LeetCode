package Sudoku;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SudokuGenerator {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        generate(3);
    }

    public static int randomize(int range) {
        return RANDOM.nextInt(1, range + 1);
    }

    public static void generate(int dimension) {
        int area = dimension * dimension;
        int[] ints = new int[area];

        ArrayList<Set<Integer>> rows = new ArrayList<>();
        ArrayList<Set<Integer>> cols = new ArrayList<>();

        int row = 0;
        int col = 0;

        int currX = 0;
        int currY = 0;
        for (int i = 0; i < area * area; i++) {
            if (i != 0 && i % dimension == 0) {
                currX = col;
                currY+=row+1;
            }

            if (i != 0 && i % area == 0) {
                System.out.println();
                col += dimension;
                currY = row;
            }

            if (i != 0 && i % (area * dimension) == 0) {
                row += dimension;
            }
            System.out.println(currX + " " + currY);
            currX+=col+1;

        }

    }
}
