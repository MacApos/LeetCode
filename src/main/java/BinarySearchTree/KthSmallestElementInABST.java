package BinarySearchTree;

import BinaryTreeGeneral.general.TreeNode;
import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{3, 1, 4, null, 2, null, null});
        TreeNode node2 = TreeNode.createNodeBreadthFirst(new Integer[]{5, 3, 6, 2, 4, null, null, 1, null, null, null,
                null, null, null, null});
        int i = kthSmallest(node, 3);
        System.out.println(i);
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> recursion = recursion(root);
        return recursion.get(k-1);
    }

    public static List<Integer> recursion(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }

        List<Integer> left = recursion(root.left);
        List<Integer> right = recursion(root.right);

        nodes.addAll(left);
        nodes.add(root.val);
        nodes.addAll(right);
        return nodes;

    }
}
