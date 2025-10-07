package Graphs.AcyclicGraphAndTopologicalSort;// Java program to find single source shortest paths in Directed Acyclic Graphs

import java.util.*;

class ShortestPath {
    static final int INF = Integer.MAX_VALUE;

    record AdjListNode(int v, int weight) {
    }

    // Class to represent graph as an adjacency list of
    // nodes of type AdjListNode
    static class Graph {
        private final int V;
        private final LinkedList<AdjListNode>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<AdjListNode>();
        }

        void addEdge(int u, int v, int weight) {
            AdjListNode node = new AdjListNode(v, weight);
            adj[u].add(node);// Add v to u's list
        }

        // A recursive function used by shortestPath.
        // See below link for details
        void topologicalSortUtil(int v, boolean[] visited, ArrayDeque<Integer> deque) {
            // Mark the current node as visited.
            visited[v] = true;

            // Recur for all the vertices adjacent to this vertex
            for (AdjListNode node : adj[v]) {
                if (!visited[node.v()])
                    topologicalSortUtil(node.v(), visited, deque);
            }
            // Push current vertex to stack which stores result
            deque.push(v);
        }

        // The function to find shortest paths from given vertex. It
        // uses recursive topologicalSortUtil() to get topological
        // sorting of given graph.
        void shortestPath(int s) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int[] dist = new int[V];

            // Mark all the vertices as not visited
            boolean[] visited = new boolean[V];

            // Call the recursive helper function to store Topological
            // Sort starting from all vertices one by one
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, deque);
                }
            }
            // Initialize distances to all vertices as infinite and
            // distance to source as 0
            Arrays.fill(dist, INF);
            dist[s] = 0;

            // Process vertices in topological order
            while (!deque.isEmpty()) {
                // Get the next vertex from topological order
                int u = deque.pop();

                // Update distances of all adjacent vertices
                if (dist[u] != INF) {
                    for (AdjListNode i : adj[u]) {
                        if (dist[i.v()] > dist[u] + i.weight())
                            dist[i.v()] = dist[u] + i.weight();
                    }
                }
            }

            // Print the calculated shortest distances
            for (int i = 0; i < V; i++) {
                System.out.print(dist[i] == INF ? "INF " : dist[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram.  Here vertex
        // numbers are 0, 1, 2, 3, 4, 5 with following mappings:
        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances " +
                "from source " + s);
        g.shortestPath(s);
    }
}
