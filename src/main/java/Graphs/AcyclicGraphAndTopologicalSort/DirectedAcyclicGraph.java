package Graphs.AcyclicGraphAndTopologicalSort;

import Graphs.Util.GraphUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectedAcyclicGraph {
    public static void main(String[] args) {
        GraphUtil g = new GraphUtil(6);

        g.addVertexData(0, "r");
        g.addVertexData(1, "s");
        g.addVertexData(2, "t");
        g.addVertexData(3, "x");
        g.addVertexData(4, "y");
        g.addVertexData(5, "z");

        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        ArrayList<ArrayList<int[]>> adjacentArrayList = g.getAdjacentListWithWeights();
        g.printList(adjacentArrayList);

//        TopologicalSort.topologicalSortListOfArrays(size, adjacentArrayList);
        int[] acyclicGraph = directedAcyclicGraph(adjacentArrayList, 1);
        System.out.println(Arrays.toString(acyclicGraph));
    }

    public static void recursion(int v, boolean[] visited, ArrayDeque<Integer> deque,
                                 ArrayList<ArrayList<int[]>> adjacentList) {

        visited[v] = true;
        for (int[] ints : adjacentList.get(v)) {
            int i = ints[0];
            if (!visited[i]) {
                recursion(i, visited, deque, adjacentList);
            }
        }
        deque.push(v);

    }

    public static int[] directedAcyclicGraph(ArrayList<ArrayList<int[]>> adjacentList, int source) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int size = adjacentList.size();
        boolean[] visited = new boolean[size];
        int[] distance = new int[size];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                recursion(i, visited, deque, adjacentList);
            }
        }

        while (!deque.isEmpty()) {
            Integer u = deque.pop();
            if (distance[u] != Integer.MAX_VALUE) {
                ArrayList<int[]> edges = adjacentList.get(u);
                for (int[] edge : edges) {
                    int v = edge[0];
                    int weight = edge[1];
                    int distanceV = distance[v];
                    int distanceU = distance[u] + weight;
                    distance[v] = Math.min(distanceV, distanceU);
                }
            }
        }
        return distance;
    }
}
