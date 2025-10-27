package Graphs.FloydWarshallAlgorithm;

import Graphs.Util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FloydWarshallAlgorithm {
    static int INF = Integer.MAX_VALUE;
    static int[][] distance;

    public static void main(String[] args) {
//        distance = Generator.populateArray(4, 8, true);
//        populateArrayWithInf(distance);

        distance = new int[][]{
                {0, 0, 2, 0},
                {0, 0, 9, 2},
                {0, 1, 0, 9},
                {6, 9, 7, 0},
        };
        Generator.printGraphForVisualization(distance);
        populateArrayWithInf(distance);

        int[][] ints = floydWarshallAlgorithmPath(distance);
        printArray(ints);
    }

    public static void populateArrayWithInf(int[][] adjacentMatrix) {
        for (int i = 0; i < adjacentMatrix.length; i++) {
            int[] row = adjacentMatrix[i];
            for (int j = 0; j < row.length; j++) {
                if (i != j && row[j] == 0) {
                    row[j] = INF;
                }
            }
        }
    }

    public static void printArray(int[][] adjacentMatrix) {
        StringBuilder result = new StringBuilder("{\n");
        for (int[] row : adjacentMatrix) {
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
        return result;
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

    public static int[][] floydWarshallAlgorithmPath(int[][] dist) {

        int[][] result = deepCopy(dist);
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            ArrayList<ArrayList<Integer>> row = new ArrayList<>();
            for (int j = 0; j < result[i].length; j++) {
                if (i == j) {
                    row.add(new ArrayList<>());
                } else if (result[i][j] != INF) {
                    row.add(new ArrayList<>(List.of(j)));
                } else {
                    row.add(null);
                }
            }
            adj.add(row);
        }

        int length = result.length;
        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                if (i != k && dist[i][k] != INF) {
                    ArrayList<Integer> ik = adj.get(i).get(k);

                    for (int j = 0; j < length; j++) {
                        if (i != j && dist[k][j] != INF) {
                            ArrayList<Integer> kj = adj.get(k).get(j);

                            if (dist[i][j] > dist[i][k] + dist[k][j]) {
                                result[i][j] = dist[i][k] + dist[k][j];

                                ArrayList<Integer> shorterPath = new ArrayList<>(ik);
                                shorterPath.addAll(kj);
                                adj.get(i).set(j, shorterPath);
                            }
                        }
                    }
                }
            }
        }
        for (ArrayList<ArrayList<Integer>> arrayLists : adj) {
            System.out.println(arrayLists);
        }

        return result;
    }


}
