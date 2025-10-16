package Graphs.problems;

import Graphs.Util.GraphUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FindTheLevelOfGivenNode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = GraphUtil.edgesMatrixToAdjacentList(
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 4}});
        int x = 1;
        int level = findLevel(adj, x);
        System.out.println(level);
    }

    public static int findLevel(ArrayList<ArrayList<Integer>> adj, int x) {
        int source = 0;
        if (x == source) {
            return 0;
        }

        int max = 0;
        for (ArrayList<Integer> nodes : adj) {
            for (Integer node : nodes) {
                if (node > max) {
                    max = node;
                }
            }
        }

        if (x >= max) {
            return -1;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[max + 1];
        visited[0] = true;
        deque.add(0);
        int level = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                Integer poll = deque.poll();
                for (Integer integer : adj.get(poll)) {
                    if (integer == x) {
                        return level;
                    }

                    if (!visited[integer]) {
                        visited[integer] = true;
                        deque.add(integer);
                    }
                }
                size--;
            }
            level++;
        }

        return level;
    }
}
