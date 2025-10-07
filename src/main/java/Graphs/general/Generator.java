package Graphs.general;


import java.util.*;

public class Generator {
    public static void main(String[] args) {
        int nodes = 4;
        int[][] ints = populateArray(nodes, 4,true);
    }

    private static int maxNumberOfEdges(int nodes, boolean directed) {
        return (nodes - 1) * (directed ? nodes : nodes / 2);
    }

    private static int randomNumberOfEdges(int nodes, boolean directed) {
        Random random = new Random();
        return random.nextInt(nodes - 1, maxNumberOfEdges(nodes, directed));
    }

    public static int[][] populateArray(int nodes,  boolean directed) {
        return populateArray(nodes, randomNumberOfEdges(nodes, directed), directed);
    }

    public static int[][] populateArray(int nodes, int edges, boolean directed) {
        Random random = new Random();
        int[][] distance = new int[nodes][nodes];
        int minNodes = 2;
        int maxNodes = 5;
        int minEdges = nodes - 1;
        int maxEdges = maxNumberOfEdges(nodes, directed);
        int minWeight = 1;
        int  maxWeight = 10;

        nodes = Math.min(Math.max(minNodes, nodes), maxNodes);
        edges = Math.min(Math.max(minEdges, edges), maxEdges);

        for (int i = 0; i < edges; i++) {
            int row;
            int col;
            boolean edgeExists;

            do {
                row = random.nextInt(0, nodes);
                col = random.nextInt(0, nodes);

                edgeExists = directed ?
                        distance[row][col] != 0 :
                        distance[row][col] != 0 || distance[col][row] != 0;
            }
            while (row == col || edgeExists);
            distance[row][col] = random.nextInt(minWeight, maxWeight + 1);
        }
        printGraph(distance);
        return distance;
    }

    public static void printGraph(int[][] distance) {
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                if (distance[i][j] != 0) {
                    System.out.println((char) (65 + i) + " " + (char) (65 + j) + " " + distance[i][j]);
                }
            }
        }
    }
}
