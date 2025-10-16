package Graphs.Util;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@Data
public class Node {
    public int val;

    @ToString.Exclude
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }


    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static Node recursion(int val, int[][] edges, Node[] created) {
        Node node = created[val];
        if (node != null) {
            return node;
        }
        node = new Node(val);
        created[val] = node;
        for (int edge : edges[val - 1]) {
            node.neighbors.add(recursion(edge, edges, created));
        }
        return node;

    }

    public static Node createNodeDepthFirst(int[][] edges) {
        Node[] created = new Node[edges.length + 1];
        return recursion(1, edges, created);
    }

    public static Node createNodeBreadthFirst(int[][] edges) {
        Node[] created = new Node[edges.length + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        created[1] = new Node(1);
        deque.add(1);

        while (!deque.isEmpty()) {
            int pop = deque.pop();
            Node node = created[pop];
            for (int i : edges[pop - 1]) {
                if (created[i] == null) {
                    created[i] = new Node(i);
                    deque.add(i);
                }
                node.neighbors.add(created[i]);
            }
        }

        return created[1];
    }
}
