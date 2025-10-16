package Graphs.General;

import java.util.ArrayDeque;
import java.util.HashSet;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int islands = numIslands(grid2);
        int islands2 = numIslandsV2(grid2);
        System.out.println(islands2);
    }

    private static final HashSet<String> visited = new HashSet<>();
    private static final ArrayDeque<int[]> deque = new ArrayDeque<>();
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    islands++;
                    recursion(grid, i, j, rows, cols);
                }
            }
        }
        return islands;
    }

    public static void recursion(char[][] grid, int i, int j, int rows, int cols) {
        deque.add(new int[]{i, j});
        visited.add(i + "," + j);

        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            int r = pop[0];
            int c = pop[1];

            for (int[] direction : directions) {
                int newRow = r + direction[0];
                int newCol = c + direction[1];
                if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == '1' && !visited.contains(newRow + "," + newCol)) {
                    deque.add(new int[]{newRow, newCol});
                    visited.add(newRow + "," + newCol);
                }
            }
        }
    }

    public static int numIslandsV2(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && visited[i][j]==0) {
                    islands++;
                    dfs(grid,visited, rows, cols, i, j);
                }
            }
        }
        return islands;
    }

    public static void dfs(char[][] grid, int[][] visited, int rows, int cols, int i, int j) {
        visited[i][j] = 1;

        if (i >= 1 && grid[i - 1][j] == '1' && visited[i - 1][j] == 0) {
            dfs(grid, visited, rows, cols, i - 1, j);
        }
        if (i < rows - 1 && grid[i + 1][j] == '1' && visited[i + 1][j] == 0) {
            dfs(grid, visited, rows, cols, i + 1, j);
        }
        if (j >= 1 && grid[i][j - 1] == '1' && visited[i][j - 1] == 0) {
            dfs(grid, visited, rows, cols, i, j - 1);
        }
        if (j < cols - 1 && grid[i][j + 1] == '1' && visited[i][j + 1] == 0) {
            dfs(grid, visited, rows, cols, i, j + 1);
        }
    }

}
