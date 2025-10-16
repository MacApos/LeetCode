package Graphs.DepthFirstSearch;

import Graphs.Util.GraphUtil;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static void main(String[] args) {
        int[][] edges = { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };
        ArrayList<ArrayList<Integer>> adj = GraphUtil.edgesMatrixToAdjacentList(edges);
        new GraphUtil().printList(adj);

        ArrayList<Integer> arrayList = depthFirstSearch(adj);
        System.out.println(arrayList);
    }

    public static void recursion(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result,
                                 boolean[] visited) {
        visited[i] = true;
        result.add(i);

        for (Integer j : adj.get(i)) {
            if (!visited[j]) {
                recursion(j, adj, result, visited);
            }
        }
    }


    public static ArrayList<Integer> depthFirstSearch(ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[size];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                recursion(i, adj, result, visited);
            }
        }
        return result;
    }

}
