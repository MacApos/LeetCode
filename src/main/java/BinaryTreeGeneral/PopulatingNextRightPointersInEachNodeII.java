package BinaryTreeGeneral;

import BinaryTreeGeneral.general.Node;
import BinaryTreeGeneral.general.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/solutions/6897946/bfs-easiest-explanation-and-cod-java-pyt-iz8k/
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Node node = Node.conversion(
                TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 3, 4, 5, null, 7}));
        Node connect = connect(node);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int level = nodes.size();
            while (level > 0) {
                level--;
                Node curr = nodes.poll();
                if (level != 0) {
                    curr.next = nodes.peek();
                }
                if (curr.left != null) {
                    nodes.push(curr.left);
                }
                if (curr.right != null) {
                    nodes.push(curr.right);
                }
            }
        }

        return root;

    }
}
