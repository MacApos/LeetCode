package Graphs.BreadthFirstSearch;

import Graphs.Util.GraphUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class BFSFromGivenSource {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = GraphUtil.edgesMatrixToAdjacentList(
                new int[][]{{1, 2}, {0, 2, 3}, {0, 1, 4}, {1, 4}, {2, 3}});

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> bfs = bfs(adj, i);
            System.out.println(bfs);
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int source) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();

        visited[source] = true;
        deque.add(source);

        while (!deque.isEmpty()) {
            Integer poll = deque.poll();
            result.add(poll);

            for (Integer integer : adj.get(poll)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    deque.add(integer);
                }
            }
        }

        return result;
    }

}
