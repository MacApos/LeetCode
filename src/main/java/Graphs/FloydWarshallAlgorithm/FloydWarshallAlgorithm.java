package Graphs.FloydWarshallAlgorithm;

import Graphs.general.Generator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FloydWarshallAlgorithm {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] dist = {
                {0, INF, 2, INF},
                {5, 0, INF, INF},
                {8, 7, 0, INF},
                {1, 2, INF, 0},
        };
        int[][] distance = Generator.populateArray(4, 6, true);
        populateArrayWithInf(distance);
        for (int[] ints : floydWarshallAlgorithm(dist)) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        for (int[] ints :floydWarshallAlgorithmV2(dist)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void populateArrayWithInf(int[][] adjacentMatrix) {
        StringBuilder result = new StringBuilder("{\n");
        for (int i = 0; i < adjacentMatrix.length; i++) {
            int[] row = adjacentMatrix[i];
            for (int j = 0; j < row.length; j++) {
                if (i != j && row[j] == 0) {
                    row[j] = INF;
                }
            }
            result.append("{")
                    .append(Arrays.stream(row)
                            .mapToObj(d -> d == Integer.MAX_VALUE ? "INF" : String.valueOf(d))
                            .collect(Collectors.joining(", ")))
                    .append("},\n");
        }
        result.append("};");
        System.out.println(result);
    }

    public static void floydWarshallAlgorithmVisualization(int[][] dist) {
        int length = dist.length;
        for (int k = 0; k < length; k++) {
            if (k < 2) {
                System.out.println("k = " + k);
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (k < 2) {
                        boolean isNotInf = dist[i][k] != INF && dist[k][j] != INF;
                        System.out.printf("dist[%d][%d] = %s\t-> dist[%d][%d] + dist[%d][%d] = %s\tupdate: %s\n",
                                i, j, dist[i][j] != INF ? dist[i][j] + ",\t" : "INF,",
                                i, k, k, j, isNotInf ? dist[i][k] + dist[k][j] + ",\t" : "INF,",
                                isNotInf && dist[i][k] + dist[k][j] < dist[i][j]);
                    }
                }
                if (k < 2) {
                    System.out.println();
                }
            }
        }
    }

    public static int[][] deepCopy(int[][] dist) {
        int V = dist.length;
        int[][] result = new int[V][V];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(dist[i], dist[i].length);
        }
        return  result;
    }

    public static int[][] floydWarshallAlgorithm(int[][] dist) {
        int V = dist.length;
        int[][] result = deepCopy(dist);
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF)
                        result[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return result;
    }

    public static int[][] floydWarshallAlgorithmV2(int[][] dist) {
        int length = dist.length;
        int[][] result = deepCopy(dist);
        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                if (i != k &&
                        /*
                        Distance in direct connection, without intermediate nodes, between one node and all its adjacent
                        nodes won't be updated because from this point it is the shortest
                         */
                        dist[i][k] != INF) {
                        /*
                        Infinity is always longer than any distance
                         */
                    for (int j = 0; j < length; j++) {
                        if (i != j &&
                           /*
                           It is matrix diagonal, which represents distance from node to itself, considering it as 0,
                           it can be omitted
                            */
                                dist[k][j] != INF) {
                            result[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        return result;
    }

}
