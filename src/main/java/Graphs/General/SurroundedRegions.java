package Graphs.General;

import Graphs.Util.GraphUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O'}
        };


        System.out.println("\t" +
                IntStream.range(0,  board[0].length)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            String collect = IntStream.range(0, row.length)
                    .mapToObj(j -> String.valueOf(row[j])).collect(Collectors.joining(" "));
            System.out.println(i + "\t" + collect);
        }

        char[][] comparison = {
                {'X', 'X', 'X', 'X', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O'}
        };

        solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != comparison[i][j]) {
                    break;
                }
            }
        }

    }

    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    helper(board, visited, rows, cols, true, i, j);
                }
            }
        }
    }

    public static boolean helper(char[][] board, int[][] visited, int rows, int cols, boolean surrounded, int i, int j) {
        visited[i][j] = 1;

        if (i == 1 && j == 6) {
            System.out.println("test");
        }

        int i_1 = i - 1;
        int i1 = i + 1;
        int j_1 = j - 1;
        int j1 = j + 1;

        if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
            surrounded = false;
        } else {


            char boardI_1 = board[i_1][j];
            int visitedI_1 = visited[i_1][j];

            char boardI1 = board[i1][j];
            int visitedI1 = visited[i1][j];

            char boardJ_1 = board[i][j_1];
            int visitedJ_1 = visited[i][j_1];

            char boardJ1 = board[i][j1];
            int visitedJ1 = visited[i][j1];
        }

        if (i >= 1 && board[i_1][j] == 'O' && visited[i_1][j] == 0) {
            surrounded = helper(board, visited, rows, cols, surrounded, i_1, j);
        }
        if (i < rows - 1 && board[i1][j] == 'O' && visited[i1][j] == 0) {
            surrounded = helper(board, visited, rows, cols, surrounded, i1, j);
        }
        if (j >= 1 && board[i][j_1] == 'O' && visited[i][j_1] == 0) {
            surrounded = helper(board, visited, rows, cols, surrounded, i, j_1);
        }
        if (j < cols - 1 && board[i][j1] == 'O' && visited[i][j1] == 0) {
            surrounded = helper(board, visited, rows, cols, surrounded, i, j1);
        }
        if (surrounded) {
            board[i][j] = 'X';
        }

        return surrounded;
    }

    private static int[][] visited;
    private static int rows;
    private static int cols;

    public static void solveV2(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    ArrayList<int[]> fill = new ArrayList<>();
                    boolean helper = helperV2(board, fill, true, i, j);
                    System.out.println(helper);
                    if (helper) {
                        for (int[] ints : fill) {
                            board[ints[0]][ints[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public static boolean helperV2(char[][] board, ArrayList<int[]> fill, boolean surrounded, int i, int j) {
        visited[i][j] = 1;
        fill.add(new int[]{i, j});

        if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
            surrounded = false;
        } else {
            char i_1 = board[i - 1][j];
            char i1 = board[i + 1][j];
            char j_1 = board[i][j - 1];
            char j1 = board[i][j + 1];
        }


        if (i >= 1 && board[i - 1][j] == 'O' && visited[i - 1][j] == 0) {
            surrounded = helperV2(board, fill, surrounded, i - 1, j);
        }
        if (i < rows - 1 && board[i + 1][j] == 'O' && visited[i + 1][j] == 0) {
            surrounded = helperV2(board, fill, surrounded, i + 1, j);
        }
        if (j >= 1 && board[i][j - 1] == 'O' && visited[i][j - 1] == 0) {
            surrounded = helperV2(board, fill, surrounded, i, j - 1);
        }
        if (j < cols - 1 && board[i][j + 1] == 'O' && visited[i][j + 1] == 0) {
            surrounded = helperV2(board, fill, surrounded, i, j + 1);
        }
        return surrounded;
    }

    private static final HashSet<String> set = new HashSet<>();

    public static void solveV3(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !set.contains(i + "," + j)) {
                    bfs(board, rows, cols, i, j);
                }
            }
        }
    }

    public static void bfs(char[][] board, int rows, int cols, int i, int j) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        set.add(i + "," + j);

        boolean fill = true;
        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            int u = pop[0];
            int v = pop[1];

            for (int[] direction : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int newU = u + direction[0];
                int newV = v + direction[1];
                if (board[newU][newV] == 'O' && (newU == 0 || newV == 0 || newU == rows - 1 || newV == cols - 1)) {
                    fill = false;
                    break;
                } else if (board[newU][newV] == 'O' && !set.contains(newU + "," + newV)) {
                    deque.add(new int[]{newU, newV});
                    set.add(newU + "," + newV);
                }
            }
            if (!fill) {
                break;
            }
        }

        if (fill) {
            for (String coordinates : set) {
                String[] split = coordinates.split(",");
                board[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 'X';
            }
        }
    }


}
