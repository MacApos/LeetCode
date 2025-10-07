package Graphs.general;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class GraphUtil {
    public int[][] adjacentMatrix;
    public ArrayList<ArrayList<int[]>> adjacentArrayList;
    public ArrayList<ArrayList<Integer>> adjacentArrayListOfIntegers;
    public ArrayList<ArrayList<AdjacentListNode>> adjacentListNode;
    public final int size;
    public String[] vertexData;

    public GraphUtil(int size) {
        this.size = size;
        this.adjacentMatrix = new int[size][size];
        this.adjacentArrayList = new ArrayList<>();
        this.adjacentArrayListOfIntegers = new ArrayList<>();
        this.adjacentListNode = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjacentArrayList.add(new ArrayList<>());
            adjacentArrayListOfIntegers.add(new ArrayList<>());
            adjacentListNode.add(new ArrayList<>());
        }
        this.vertexData = new String[size];
    }

    public <T> void printList(ArrayList<ArrayList<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            String collect = list.get(i).stream().map(e -> {
                if (e instanceof Integer) {
                    return e.toString();
                }
                if (e instanceof int[]) {
                    return Arrays.toString((int[]) e);
                }
                return "";
            }).collect(Collectors.joining(", "));
            System.out.printf("%s\t%s\n", vertexData[i] == null ? i : vertexData[i], collect);
        }
    }

    public int[][] getAdjacentMatrix() {
        for (int[] matrix : adjacentMatrix) {
            System.out.println(Arrays.toString(matrix));
        }
        return adjacentMatrix;
    }

    //    u - vertex 1., v - vertex 2., weight - edge weight
    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjacentArrayList.get(u).add(new int[]{v, weight});
            adjacentListNode.get(u).add(new AdjacentListNode(v, weight));
            adjacentMatrix[u][v] = weight;
        }
    }

    public void addUndirectedEdge(int u, int v, int weight) {
        addEdge(u, v, weight);
        addEdge(v, u, weight);
    }

    public void addVertexData(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    public static ArrayList<ArrayList<Integer>> createList(int[][] edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();
        for (int[] vertex : edges) {
            treeMap.computeIfAbsent(vertex[0], k -> new TreeSet<>()).add(vertex[1]);
        }

        for (TreeSet<Integer> nodes : treeMap.values()) {
            result.add(new ArrayList<>(nodes));
        }

        return result;
    }

    public static ArrayList<ArrayList<int[]>> adjacentMatrixToArrayList(int[][] matrix){
        ArrayList<ArrayList<int[]>> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]!=0) {
                    result.get(i).add(new int[]{j, matrix[i][j]});
                }
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> adjacentMatrixToArrayListOfIntegers(int[][] edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] edge : edges) {
            int vertex = edge[0];
            while (result.size()-1 < vertex){
                result.add(new ArrayList<>());
            }
            result.get(vertex).add(edge[1]);
        }
        return result;
    }

    public static int[][] createMatrix(int[][] matrix) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeMap<Integer, HashSet<Integer>> treeMap = new TreeMap<>();
        for (int[] row : matrix) {
            treeMap.computeIfAbsent(row[0], k -> new HashSet<>()).add(row[1]);
            treeSet.add(row[1]);
        }
        int[][] input = new int[treeMap.size()][treeSet.size()];
        ArrayList<Integer> cols = new ArrayList<>(treeSet);
        int i = 0;
        for (Map.Entry<Integer, HashSet<Integer>> entry : treeMap.entrySet()) {
            for (Integer integer : entry.getValue()) {
                int j = cols.indexOf(integer);
                input[i][j] = 1;
            }
            i++;
        }

        System.out.println("\t" + cols);
        int k = 0;
        for (Integer integer : treeMap.keySet()) {
            System.out.printf("""
                    %d\t%s
                    """, integer, Arrays.toString(input[k++]));
        }
        return input;
    }
}

