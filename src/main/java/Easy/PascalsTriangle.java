package Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(6));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                rows.add(number);
                number = number * (i - j) / (j + 1);
            }
            result.add(rows);
        }
        return result;
    }
}
