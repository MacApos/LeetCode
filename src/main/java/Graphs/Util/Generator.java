package Graphs.Util;


import java.util.*;

public class Generator {
    public static void main(String[] args) {
        int[][]    ints;
         ints = new int[][]{
                {0, 10, 0, 5},
                {-4, 0, -6, 9},
                {0, -10, 0, -1},
                {-10, 0, 0, 0}
        };
        ints = populateAdjacentMatrix(4, 8, true);

        printGraphForVisualization(ints);
        printAdjacentMatrix(ints);
        ArrayList<ArrayList<int[]>> arrayLists = GraphUtil.adjacentMatrixToAdjacentListWithWeights(ints);
        GraphUtil.printAdjacentListAsMatrixV2(arrayLists);
    }

    private static int maxNumberOfEdges(int nodes, boolean directed) {
        return (nodes - 1) * nodes / (directed ? 1 : 2);
    }

    private static int randomNumberOfEdges(int nodes, boolean directed) {
        Random random = new Random();
        return random.nextInt(nodes - 1, maxNumberOfEdges(nodes, directed));
    }

    public static int[][] populateAdjacentMatrix(int nodes, boolean directed) {
        return populateAdjacentMatrix(nodes, randomNumberOfEdges(nodes, directed), directed);
    }

    public static int[][] populateAdjacentMatrix(int nodes, int edges, boolean directed) {
        Random random = new Random();
        int[][] distance = new int[nodes][nodes];
        int minNodes = 2;
        int maxNodes = 5;
        int minEdges = nodes - 1;
        int maxEdges = maxNumberOfEdges(nodes, directed);
        int minWeight = 1;
        int maxWeight = 10;

        nodes = Math.min(Math.max(minNodes, nodes), maxNodes);
        edges = Math.min(Math.max(minEdges, edges), maxEdges);

        HashSet<String> verticesSet = new HashSet<>();
        for (int i = 0; i < edges; i++) {
            int u;
            int v;
            String str;
            do {
                u = random.nextInt(0, nodes);
                v = random.nextInt(0, nodes);
                str = u + "" + v;
            }
            while (u == v || verticesSet.contains(str));
            verticesSet.add(str);

            int randomWeight = random.nextInt(minWeight, maxWeight + 1);
            distance[u][v] = randomWeight;
            if (!directed) {
                verticesSet.add(v + "" + u);
                distance[v][u] = randomWeight;
            }
        }
        return distance;
    }

    public static void printAdjacentMatrix(int[][] array) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < array.length; i++) {
            sb.append("{");
            int[] a = array[i];
            for (int j = 0; j < a.length; j++) {
                sb.append(a[j]);
                if (j < a.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i < array.length - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n};");
        System.out.println(sb);
    }

    public static void printGraphForVisualization(int[][] distance) {
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                if (distance[i][j] != 0) {
                    System.out.println((char) (65 + i) + " " + (char) (65 + j) + " " + distance[i][j]);
                }
            }
        }
    }
}
