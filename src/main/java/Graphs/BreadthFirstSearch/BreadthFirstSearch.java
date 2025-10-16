package Graphs.BreadthFirstSearch;

import Graphs.Util.GraphUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));
        new GraphUtil().printList(adj);

    }

    public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adj){
        int size = adj.size();
        boolean[] visited = new boolean[size];

        
    }
}
