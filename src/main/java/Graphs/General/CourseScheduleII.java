package Graphs.General;

import Graphs.FloydWarshallAlgorithm.FloydWarshallAlgorithm;
import Graphs.Util.GraphUtil;

import java.util.*;

public class CourseScheduleII {
    public static int[][] prerequisites;

    public static void main(String[] args) {
        int numCurses = 5;
        prerequisites = GraphUtil.stringToIntArray("[[1,4],[2,4],[3,1],[3,2]]");
        int[][] matrix = new int[numCurses][numCurses];
        for (int[] prerequisite : prerequisites) {
            matrix[prerequisite[0]][prerequisite[1]]=1;
        }
        findOrderV2(numCurses, prerequisites);

    }

    static HashMap<Integer, ArrayList<ArrayList<Integer>>> map1 = new HashMap<>();

    public static void findOrderV2(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            map1.computeIfAbsent(prerequisite[0], (k) -> new ArrayList<>()).add(new ArrayList<>(prerequisite[1]));
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (Integer integer : map1.keySet()) {

        }

    }

    public static void recursion(ArrayList<Integer> list) {
        for (Integer integer : list) {

        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!adjList.get(i).isEmpty() && !visited[i]) {
                result = dfs(adjList, i, visited, inPath, new ArrayList<>());
                if (result.isEmpty()) {
                    return new int[0];
                }
                visited[i] = false;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] inPath,
                                         ArrayList<Integer> result) {
        visited[node] = true;
        inPath[node] = true;

        result.add(node);
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(adj, neighbour, visited, inPath, result).isEmpty()) {
                    return new ArrayList<>();
                }
            } else if (inPath[neighbour]) {
                return new ArrayList<>();
            }

        }

        inPath[node] = false;
        return result;
    }
}
