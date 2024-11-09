package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'1', '2', '.', '.', '3', '.', '.', '.', '7'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '2'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '1'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

//        mineIsValidSudoku(board);
        System.out.println(isValidSudoku(board2));
    }

    public static boolean mineIsValidSudoku(char[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Integer> subBoxHashSet = new HashSet<>();

        int addI = 0;
        int addJ = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(board[i][j]).append(",");
                int numericValue = Character.getNumericValue(board[i][j]);

                if (numericValue != -1) {
                    System.out.println(subBoxHashSet.add(numericValue));
                }
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        HashMap<Integer, Set<Character>> rowsHashMap = new HashMap<>();
        HashMap<Integer, Set<Character>> colsHashMap = new HashMap<>();
        HashMap<String, Set<Character>> squaresHashMap = new HashMap<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char currentCell = board[r][c];
                if (currentCell == '.') {
                    continue;
                }

                String squareKey = r / 3 + "-" + c / 3;
                rowsHashMap.computeIfAbsent(r, f -> new HashSet<>());
                colsHashMap.computeIfAbsent(c, f -> new HashSet<>());
                squaresHashMap.computeIfAbsent(squareKey, f -> new HashSet<>());

                boolean addR = rowsHashMap.get(r).add(currentCell);
                boolean addC = colsHashMap.get(c).add(currentCell);
                boolean addSquare = squaresHashMap.get(squareKey).add(currentCell);

                if (!addR || !addC || !addSquare) {
                    return false;
                }
            }
        }
        return true;
    }
}
