package Graphs.Util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[][] edges = GraphUtil.stringToIntArray("[[2,4,3],[1,3],[2,4],[1,3]]");
        Node node = Node.createNodeBreadthFirst(edges);
    }
}
