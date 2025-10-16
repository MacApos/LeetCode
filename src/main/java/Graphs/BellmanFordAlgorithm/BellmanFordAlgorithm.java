package Graphs.BellmanFordAlgorithm;

import Graphs.Util.GraphUtil;
import Graphs.Util.Result;

import java.util.Arrays;

public class BellmanFordAlgorithm {
private static final int size = 3;
    private static String[] vertexData;
    private static int[][] adjMatrix;

    public static void main(String[] args) {
        GraphUtil g = new GraphUtil(size);

        g.addVertexData(0, "A");
        g.addVertexData(1, "C");
        g.addVertexData(2, "D");

        g.addEdge(0, 1, 4);
        g.addEdge(1, 0, -7);
        g.addEdge(2, 0, 4);
        g.addEdge(2, 1, 7);

        vertexData = g.getVertexData();
        adjMatrix = g.getAdjacentMatrix();

        Result result = bellmanFord("D");
        if (result.hasNegativeCycle()){
            System.out.println("Negative cycle");
            System.out.println(Arrays.toString(result.distances()));
        } else {
            System.out.println(Arrays.toString(result.distances()));
        }
    }

    public static Result bellmanFord(String startVertexData){
        int startVertex = -1;
        for (int i = 0; i < size; i++) {
            if (vertexData[i].equals(startVertexData)) {
                startVertex = i;
                break;
            }
        }
        if (startVertex == -1) {
            return new Result(true, null); // Start vertex not found
        }

        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < size - 1; i++) {
            System.out.printf("i=%d\n",i);
            for (int u = 0; u < size; u++) {
                System.out.printf("\tu=%d\n",u);
                for (int v = 0; v < size; v++) {
                    System.out.printf("\t\tv=%d\n",v);
                    String tab = "\t\t\t";
                    if(adjMatrix[u][v] == 0 ){
                        System.out.printf(tab+"X m[%d][%d]==0\n",u,v);
                    } else if(distances[u] == Integer.MAX_VALUE){
                        System.out.printf(tab+"X d[%d]==∞\n",u);
                    } else if(distances[u] + adjMatrix[u][v] < distances[v]){
                        System.out.printf(tab+"✓ changing d[%d] from %d to %d + %d\n",v, distances[v], distances[u], adjMatrix[u][v]);
                        distances[v] = distances[u] + adjMatrix[u][v];
                    } else {
                        System.out.printf(tab+"X d[%d]=%d <= %d + %d\n",v, distances[v], distances[u], adjMatrix[u][v]);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(distances));
        // Check for negative weight cycle
        for (int u = 0; u < size; u++) {
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + adjMatrix[u][v] < distances[v]) {
                    return new Result(true, null);
                }
            }
        }

        return new Result(false, distances);

    }

}
