package Graphs.General;

import Graphs.Util.GraphUtil;

import java.util.*;
import java.util.stream.Collectors;

public class EvaluateDivision {
    public static List<List<String>> equations;
    public static double[] values;
    public static List<List<String>> queries;
    public static double[][] array;
    public static int[][] visited;
    public static ArrayList<String> list;

    public static void main(String[] args) {
        equations = List.of(
                List.of("a", "b"),
                List.of("b", "c"),
                List.of("bc", "cd"));
        values = new double[]{1.5, 2.5, 5.0};
        queries = List.of(
                List.of("a", "c"),
                List.of("c", "b"),
                List.of("bc", "cd"),
                List.of("cd", "bc")
        );

//        equations = List.of(
//                List.of("a", "b"),
//                List.of("b", "c"));
//        values = new double[]{2.0, 3.0};
//        queries = List.of(
//                List.of("a", "c"),
//                List.of("b", "a"),
//                List.of("a", "e"),
//                List.of("a", "a"),
//                List.of("x", "x"));
        calcEquation(equations, values, queries);
//        dijkstra();
//        System.out.println();
        floydWarshall();
    }


    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] doubles = new double[queries.size()];
        Arrays.fill(doubles, -1);

        list = new ArrayList<>();
        for (List<String> equation : equations) {
            for (String s : equation) {
                if (!list.contains(s)) {
                    list.add(s);
                }
            }
        }

        int size = list.size();
        array = new double[size][size];
        visited = new int[size][size];
        for (int i = 0; i < equations.size(); i++) {
            int x = list.indexOf(equations.get(i).get(0));
            int y = list.indexOf(equations.get(i).get(1));
            array[x][x] = 1;
            array[y][y] = 1;
            array[x][y] = values[i];
            array[y][x] = 1 / values[i];
        }

        for (double[] d : array) {
            System.out.println(Arrays.toString(d));
        }

        for (int k = 0; k < 1; k++) {
            List<String> query = queries.get(k);
            int i = list.indexOf(query.get(0));
            int j = list.indexOf(query.get(1));
            if (i == -1 || j == -1) {
                continue;
            }
            if (array[i][j] != 0) {
                doubles[k] = array[i][j];
            } else {
                doubles[k] = dfs(i, i, j, 1);
            }

        }

        return doubles;

    }

    public static double dfs(int start, int intermediate, int stop, double result) {
        if (visited[start][intermediate] == 1) {
            return array[start][intermediate];
        }
        result = result * array[start][intermediate];
        for (int k = 0; k < array[start].length; k++) {
            visited[start][k] = 1;
            if (k == stop) {
                return result;
            }
            double d = array[start][k];
            if (d != 0 && d != 1) {
                dfs(k, intermediate, stop, result);
            }

        }
        return -1;
    }

    public static double dijkstra() {
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        for (List<String> equation : equations) {
            int i = list.indexOf(equation.get(0));
            int j = list.indexOf(equation.get(1));
            hashMap.computeIfAbsent(i, (v) -> new HashSet<>()).add(j);
            hashMap.computeIfAbsent(j, (v) -> new HashSet<>()).add(i);
        }

        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry : hashMap.entrySet()) {
            edges.add(entry.getKey(), entry.getValue().stream()
                    .map(i -> new int[]{i, 1})
                    .collect(Collectors.toCollection(ArrayList::new)));
        }

        GraphUtil.printAdjacentList(edges);
        int size = edges.size();
        ArrayList<ArrayList<ArrayList<Integer>>> grid = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<>());

            for (int j = 0; j < size; j++) {
                grid.get(i).add(new ArrayList<>());
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
            int[] distance = new int[size];
            boolean[] visited = new boolean[size];

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;
            pq.add(new int[]{i, 0});


            while (!pq.isEmpty()) {
                int u = pq.poll()[0];
                if (visited[u]) {
                    continue;
                }
                visited[u] = true;
                for (int[] neighbour : edges.get(u)) {
                    int v = neighbour[0];
                    int weight = neighbour[1];
                    int shorter = distance[u] + weight;
                    if (distance[v] > shorter) {
                        distance[v] = shorter;
                        pq.add(new int[]{v, distance[v]});

                        ArrayList<ArrayList<Integer>> arrayLists = grid.get(i);
                        ArrayList<Integer> a = new ArrayList<>(arrayLists.get(u));
                        a.add(v);
                        arrayLists.set(v, a);
                    }
                }
            }

            System.out.println(grid.get(i));

        }
        return 0;

    }

    public static void floydWarshall() {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ArrayList<ArrayList<Integer>> row = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    row.add(new ArrayList<>());
                } else {
                    row.add(null);
                }
            }
            adj.add(row);
        }

        for (List<String> equation : equations) {
            int i = list.indexOf(equation.get(0));
            int j = list.indexOf(equation.get(1));

            ArrayList<ArrayList<Integer>> rowI = adj.get(i);
            if (rowI.get(j) == null) {
                rowI.set(j, new ArrayList<>());
            }
            rowI.get(j).add(j);

            ArrayList<ArrayList<Integer>> rowJ = adj.get(j);
            if (rowJ.get(i) == null) {
                rowJ.set(i, new ArrayList<>(i));
            }
            rowJ.get(i).add(i);
        }


        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> ik = adj.get(i).get(k);
                if (ik == null) {
                    continue;
                }
                for (int j = 0; j < size; j++) {
                    ArrayList<Integer> kj = adj.get(k).get(j);
                    if (kj == null) {
                        continue;
                    }

                    ArrayList<Integer> ij = adj.get(i).get(j);
                    if (ij == null || ij.size() > ik.size() + kj.size()) {
                        ArrayList<Integer> shorterPath = new ArrayList<>(ik);
                        shorterPath.addAll(kj);
                        adj.get(i).set(j, shorterPath);
                    }
                }
            }
        }

        for (ArrayList<ArrayList<Integer>> arrayLists : adj) {
            System.out.println(arrayLists);
        }

    }

}
