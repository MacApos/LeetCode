package Graphs.General;

import Graphs.Util.GraphUtil;
import Graphs.Util.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class CloneGraph {
    public static void main(String[] args) {
        int[][] ints = GraphUtil.stringToIntArray("[[2,4],[1,3],[2,4],[1,3]]");
        Node node = Node.createNodeBreadthFirst(ints);
        Node cloned = cloneGraph(node);
        Node clonedV2 = cloneGraphV2(node);
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node, new ArrayList<>());
    }

    public static Node dfs(Node node, ArrayList<Node> created) {

        int val = node.val;

        while (created.size() <= val) {
            created.add(null);
        }

        Node cloned = created.get(val);
        if (cloned != null) {
            return cloned;
        }

        created.set(val, new Node(val, new ArrayList<>()));
        cloned = created.get(val);
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(dfs(neighbor, created));
        }

        return cloned;
    }

    public static Node[] created = new Node[0];
    public static Node cloneGraphV2(Node node) {
        if (node == null) {
            return null;
        }
        int val = node.val;

        if (created.length <= val) {
            created=Arrays.copyOf(created, val+1);
        }

        Node cloned = created[val];
        if (cloned != null) {
            return cloned;
        }

        created[val] = new Node(val, new ArrayList<>());
        cloned = created[val];
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraphV2(neighbor));
        }

        return cloned;
    }

}
