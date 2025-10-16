package Graphs.AcyclicGraphAndTopologicalSort;

import Graphs.Util.GraphUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TopologicalSort {
    public static void main(String[] args) {
        int[][] adjacentMatrix = new int[][]{
                {2, 3}, {3, 1}, {4, 0},
                {4, 1}, {5, 0}, {5, 2}};
        ArrayList<ArrayList<Integer>> adjacentList = GraphUtil.edgesMatrixToAdjacentList(adjacentMatrix);
        topologicalSort(adjacentList.size(), adjacentList);
    }

    public static void topologicalSortUtil(int i, ArrayList<ArrayList<Integer>> adjacentList,
                                           boolean[] visited, ArrayDeque<Integer> deque) {
        visited[i] = true;
        for (Integer j : adjacentList.get(i)) {
            if (!visited[j]) {
                topologicalSortUtil(j, adjacentList, visited, deque);
            }
        }
        deque.push(i);
    }

    public static int[] topologicalSortListOfArrays(int v, ArrayList<ArrayList<int[]>> adjacentList) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (ArrayList<int[]> list : adjacentList) {
            arrayLists.add(list.stream().map(a -> a[0]).collect(Collectors.toCollection(ArrayList::new)));
        }
        return topologicalSort(v, arrayLists);
    }

    public static int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adjacentList) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[v];
        int[] result = new int[v];

        for (int i = 0; i < adjacentList.size(); i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, adjacentList, visited, deque);
            }
        }

        int index = 0;
        while (!deque.isEmpty()) {
            result[index] = deque.pop();
            index++;
        }

        return result;
    }
}
