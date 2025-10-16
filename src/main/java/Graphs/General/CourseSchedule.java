package Graphs.General;

import Graphs.Util.GraphUtil;

import java.util.*;

public class CourseSchedule {
    public static int[][] prerequisites;

    public static void main(String[] args) {
        int numCourses = 5;
//        prerequisites = GraphUtil.stringToIntArray("[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]");
        prerequisites = GraphUtil.stringToIntArray("[[1,4],[2,4],[3,1],[3,2]]");

        boolean b = canFinish(numCourses, prerequisites);


    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!adj.get(i).isEmpty() && !visited[i]) {
                if (!dfs(i, adj, visited, inPath)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (!dfs(neighbour, adj, visited, inStack)) {
                    return false;
                }
            } else if (inStack[neighbour]) {
                return false;
            }
        }

        inStack[node] = false;
        return true;
    }

    public static boolean canFinishV2(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            hashMap.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            hashMap.get(prerequisite[0]).add(prerequisite[1]);
            arr[prerequisite[1]]++;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            for (Integer integer : hashMap.get(pop)) {
                arr[integer]--;
                if (arr[integer] == 0) {
                    deque.add(integer);
                }
            }
        }

        for (int i : arr) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean canFinishV3(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            hashMap.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
            arr[prerequisite[1]]++;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (arr[i] == 0) {
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            if (hashMap.containsKey(pop)) {
                for (Integer integer : hashMap.get(pop)) {
                    arr[integer]--;
                    if (arr[integer] == 0) {
                        deque.add(integer);
                    }
                }
            }
        }

        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }

        return true;
    }

}
