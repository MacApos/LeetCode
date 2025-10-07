package Graphs.DijkstrasAlgorithm;

import Graphs.general.GraphUtil;

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

//        g.addEdge(2, 0, 4);// D - A, weight 5
//        g.addEdge(2, 3, 2);// D - E, weight 2
//        g.addEdge(0, 1, 3);// A - C, weight 3
//        g.addEdge(0, 3, 4);// A - E, weight 4
//        g.addEdge(3, 1, 4);// E - C, weight 4

//        g.addVertexData(0, "A");
//        g.addVertexData(1, "B");
//        g.addVertexData(2, "C");
//        g.addVertexData(3, "D");
//        g.addVertexData(4, "E");
//        g.addVertexData(5, "F");
//        g.addVertexData(6, "G");

//        g.addEdge(3, 0, 4);// D - A, weight 5
//        g.addEdge(3, 4, 2);// D - E, weight 2
//        g.addEdge(0, 2, 3);// A - C, weight 3
//        g.addEdge(0, 4, 4);// A - E, weight 4
//        g.addEdge(4, 2, 4);// E - C, weight 4
//        g.addEdge(4, 6, 5);// E - G, weight 5
//        g.addEdge(2, 5, 5);// C - F, weight 5
//        g.addEdge(2, 1, 2);// C - B, weight 2
//        g.addEdge(1, 5, 2);// B - F, weight 2
//        g.addEdge(6, 5, 5);// G - F, weight 5

        vertexData = g.getVertexData();
        adjMatrix = g.getAdjacentMatrix();
        for (int[] matrix : adjMatrix) {
            System.out.println(Arrays.toString(matrix));
        }
        ArrayList<ArrayList<int[]>> adjacentArrayList = g.getAdjacentArrayList();

        int src = 0;
//        int[] dijkstra = dijkstra(adjacentArrayList, src);
        int[] dijkstra2 = dijkstraV2(adjacentArrayList, src);
//        int[] dijkstra3 = dijkstraV3(adjacentArrayList, src);
//        int[] dijkstra4 = dijkstraV4("D");
//        int[] dijkstra5 = dijkstraV5(adjacentArrayList, src);
//        System.out.println(Arrays.toString(dijkstra));
        System.out.println(Arrays.toString(dijkstra2));
//        System.out.println(Arrays.toString(dijkstra3));
//        System.out.println(Arrays.toString(dijkstra4));
//        System.out.println(Arrays.toString(dijkstra5));
    }

    public static int[] dijkstra(ArrayList<ArrayList<int[]>> edges, int src) {
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

    public static int[] dijkstraV5(ArrayList<ArrayList<int[]>> edges, int src) {
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

    static int[] dijkstraV2(ArrayList<ArrayList<int[]>> edges, int src) {

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

    static int[] dijkstraV3(ArrayList<ArrayList<int[]>> edges, int src) {
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

    public static int[] dijkstraV4(String startVertexData) {
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
