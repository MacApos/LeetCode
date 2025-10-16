package Graphs.DijkstrasAlgorithm;

import Graphs.Util.Generator;
import Graphs.Util.GraphUtil;

import java.util.*;

public class DijkstrasAlgorithm {
    public static final int size = 4;
    public static String[] vertexData;
    public static int[][] adjMatrix;

    public static void main(String[] args) {
        GraphUtil g = new GraphUtil(size);
        g.addVertexData(0, "A");
        g.addVertexData(1, "C");
        g.addVertexData(2, "D");
        g.addVertexData(3, "E");

        g.addEdge(0, 1, 3);// A - C, weight 5
        g.addEdge(0, 2, 2);// A - D, weight 5
        g.addEdge(0, 3, 5);// A - E, weight 2
        g.addEdge(1, 3, 1);// C - E, weight 3
        g.addEdge(2, 3, 8);// D - E, weight 3

        int src = 2;
//        int[][] edges = Generator.populateArray(4, 5,false);
        int[][] edges = {
                {0, 2, 6, 1},
                {2, 0, 0, 5},
                {6, 0, 0, 4},
                {1, 5, 4, 0}
        };
        Generator.printGraph(edges);
        Generator.printArray(edges);
        ArrayList<ArrayList<int[]>> adj = GraphUtil.adjacentMatrixToAdjacentListWithWeights(edges);
        new GraphUtil().printList(adj);
        int[] dijkstra = dijkstra(adj, src);
        System.out.println(Arrays.toString(dijkstra));
    }

    public static int[] dijkstraSet(ArrayList<ArrayList<int[]>> edges, int src) {
        Set<Integer> hashSet = new LinkedHashSet<>();
        int[] distance = new int[edges.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[edges.size()];

        distance[src] = 0;
        hashSet.add(src);

        while (!hashSet.isEmpty()) {
            int u = hashSet.iterator().next();
            hashSet.remove(u);
            visited[u] = true;
            ArrayList<int[]> uEdges = edges.get(u);
            for (int[] edge : uEdges) {
                int v = edge[0];
                if (visited[v]) {
                    continue;
                }
                int weight = edge[1];
                distance[v] = Math.min(distance[v], distance[u] + weight);
                hashSet.add(v);
            }
        }
        return distance;
    }


    public static int[] dijkstraDeque(ArrayList<ArrayList<int[]>> edges, int src) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] distance = new int[edges.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[edges.size()];

        distance[src] = 0;
        visited[src] = true;
        deque.add(src);

        int count = 0;
        while (!deque.isEmpty()) {
            int u = deque.poll();
            visited[u] = true;
            for (int[] edge : edges.get(u)) {
                int v = edge[0];
                if (visited[v]) {
                    continue;
                }
                int weight = edge[1];
                int distanceV = distance[v];
                int distanceU = distance[u] + weight;

                distance[v] = Math.min(distance[v], distance[u] + weight);
                deque.add(v);
            }
            count++;
        }
        System.out.println(count);
        return distance;
    }

    static int[] dijkstra(ArrayList<ArrayList<int[]>> edges, int src) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        int size = edges.size();
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (int[] neighbor : edges.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                int shortestDist = distance[u] + weight;
                if (distance[v] > shortestDist) {
                    distance[v] = shortestDist;
                    pq.add(new int[]{v, shortestDist});
                }
            }
        }

        return distance;
    }

    static int[] dijkstraPriorityQueue(ArrayList<ArrayList<int[]>> edges, int src) {

        // PriorityQueue to store vertices to be processed
        // Each element is a pair: [distance, node]
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));

        // Create a distance array and initialize all distances as infinite
        int[] distance = new int[edges.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Insert source with distance 0
        distance[src] = 0;
        pq.add(new int[]{src, 0});

        // Loop until the priority queue is empty
        while (!pq.isEmpty()) {

            // Get the node with the minimum distance
            int u = pq.poll()[0];

            // Traverse all adjacent vertices of the current node
            for (int[] neighbor : edges.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // If there is a shorter path to v through u
                if (distance[v] > distance[u] + weight) {
                    // Update distance of v
                    distance[v] = distance[u] + weight;

                    // Add updated pair to the queue
                    pq.add(neighbor);
                }
            }
        }

        // Return the shortest distance array
        return distance;
    }

    static int[] dijkstraConvertedFromPython(ArrayList<ArrayList<int[]>> edges, int src) {
        int[] distance = new int[edges.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[edges.size()];
        distance[src] = 0;

        for (int i = 0; i < edges.size(); i++) {
            int minDistance = Integer.MAX_VALUE;
            Integer u = null;

            for (int j = 0; j < edges.size(); j++) {
                if (!visited[j] && distance[j] < minDistance) {
                    minDistance = distance[j];
                    u = j;
                }
            }

            if (u == null) {
                return distance;
            }
            visited[u] = true;

            for (int[] ints : edges.get(u)) {
                int v = ints[0];
                int weight = ints[1];
                if (!visited[v]) {
                    int alt = distance[u] + weight;
                    if (alt < distance[v]) {
                        distance[v] = alt;
                    }
                }
            }
        }
        return distance;
    }

    public static int[] dijkstraConvertedFromPythonV2(String startVertexData) {
        int startVertex = findIndex(startVertexData);
        int[] distances = new int[size];
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[startVertex] = 0;

        for (int i = 0; i < size; i++) {
            int u = minDistance(distances, visited);
            if (u == -1) break;

            visited[u] = true;
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                    int newDist = distances[u] + adjMatrix[u][v];
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                    }
                }
            }
        }
        return distances;
    }

    private static int findIndex(String data) {
        for (int i = 0; i < size; i++) {
            if (vertexData[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    private static int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < size; v++) {
            if (!visited[v] && distances[v] < min) {
                return v;
//                min = distances[v];
//                minIndex = v;

            }
        }
        return minIndex;
    }
}
