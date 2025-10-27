package Graphs.Util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class GraphUtil {
    // full adjacent matrix
    public int[][] adjacentMatrix;
    /*
    edges matrix - connections are represented with arrays of 2 nodes
    0 → 1 ←→ 2
    int[][] edges = new int[][]{} = {{0, 1}, {1, 2}, {2,1}}
     */

    public ArrayList<ArrayList<int[]>> adjacentListWithWeights;
    public ArrayList<ArrayList<Integer>> adjacentList;
    public int size;
    public  String[] vertexData;

    public GraphUtil(int size) {
        this.size = size;
        this.adjacentMatrix = new int[size][size];
        this.adjacentListWithWeights = new ArrayList<>();
        this.adjacentList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjacentListWithWeights.add(new ArrayList<>());
            adjacentList.add(new ArrayList<>());
        }
        this.vertexData = new String[size];
    }

    public static int[][] stringToIntArray(String testcase) {
        String[] split = testcase.split("],");
        int[][] result = new int[split.length][];

        for (int i = 0; i < split.length; i++) {
            String[] integers = split[i].replaceAll("\\[*]*", "").split(",");
            result[i] = new int[integers.length];
            for (int j = 0; j < integers.length; j++) {
                result[i][j] = Integer.parseInt(integers[j]);
            }
        }
        return result;
    }

    private static  <T> ArrayList<String> collectData(ArrayList<ArrayList<T>> list) {
        ArrayList<String> collected = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String collect = list.get(i).stream().map(e -> {
                if (e instanceof Integer) {
                    return e.toString();
                }
                if (e instanceof int[]) {
                    return "{" + Arrays.stream((int[]) e)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ")) + "}";
                }
                return "";
            }).collect(Collectors.joining(", "));
            collected.add(collect);
        }
        return collected;
    }

    public  <T> void printAdjacentListWithVertexData(ArrayList<ArrayList<T>> list) {
        ArrayList<String> collected = collectData(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s\t%s\n", vertexData == null || vertexData[i] == null ? i : vertexData[i], collected.get(i));
        }
    }

    public static  <T> void printAdjacentList(ArrayList<ArrayList<T>> list) {
        ArrayList<String> collected = collectData(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s\t%s\n",  i, collected.get(i));
        }
    }

    public static  <T> void printAdjacentListAsMatrix(ArrayList<ArrayList<T>> list) {
        ArrayList<String> collected = collectData(list);
        System.out.println("{");
        for (int i = 0; i < list.size(); i++) {
            String s = String.format("{%s}",  collected.get(i));
            if(i < list.size() - 1){
                s += ",";
            }
            System.out.printf("%s\n", s);
        }
        System.out.println("};");
    }

    public static void printAdjacentListAsMatrixV2(ArrayList<ArrayList<int[]>> list) {
        System.out.println("{");
        for (int i = 0; i < list.size(); i++) {

            for (int[] anInt : list.get(i)) {
                String collect = Arrays.stream(anInt).mapToObj(String::valueOf).collect(Collectors.joining(", "));
                System.out.printf("{%s, %s},\n", i, collect);
            }
        }
        System.out.println("};");
    }

    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjacentListWithWeights.get(u).add(new int[]{v, weight});
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

    // full matrix
    public static ArrayList<ArrayList<int[]>> adjacentMatrixToAdjacentListWithWeights(int[][] matrix) {
        ArrayList<ArrayList<int[]>> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    result.get(i).add(new int[]{j, matrix[i][j]});
                }
            }
        }
        return result;
    }

    // edges matrix
    private static ArrayList<ArrayList<Integer>> edgesMatrixToAdjacentList(int[][] edges,
                                                                           boolean directed) {
        ArrayList<TreeSet<Integer>> result = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            while (result.size() - 1 < Math.max(u, v)) {
                result.add(new TreeSet<>());
            }
            result.get(u).add(v);
            if (!directed) {
                result.get(v).add(u);
            }
        }
        return result.stream().map(ArrayList::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<ArrayList<Integer>> edgesMatrixToUndirectedAdjacentList(int[][] edges) {
        return edgesMatrixToAdjacentList(edges, false);
    }

    public static ArrayList<ArrayList<Integer>> edgesMatrixToAdjacentList(int[][] edges) {
        return edgesMatrixToAdjacentList(edges, true);
    }
}

