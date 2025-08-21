package BinaryTreeGeneral.general;

import lombok.Data;

import java.util.*;

@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode breadthFirstListToNode(int[] values) {
        int j = 1;
        for (int i = 0; j < values.length; i++) {
            System.out.printf("%d %d %d\n", i, j++, j++);
        }
        return null;
    }

    private static void checkTreeValues(int start, int maxLength, int length) {
        int maxCurrLength = maxLength + (int) Math.pow(2, start);
        if (maxCurrLength < length) {
            checkTreeValues(start + 1, maxCurrLength, length);
        } else if (maxCurrLength != length) {
            throw new IllegalArgumentException("Invalid tree values");
        }
    }

    private static TreeNode breadthFirst(int i, Integer[] values) {
        Integer integer = values[i];
        if (integer == null) {
            return null;
        }
        TreeNode node = new TreeNode(integer);
        int leftNodeVal = 2 * i + 1;
        int rightNodeVal = 2 * i + 2;
        node.left = leftNodeVal < values.length ? breadthFirst(leftNodeVal, values) : null;
        node.right = rightNodeVal < values.length ? breadthFirst(rightNodeVal, values) : null;
        return node;
    }

    private static TreeNode inorderTraversal(Integer[] values) {
        int length = values.length;
        int root = length / 2;
        Integer integer = values[root];
        if (integer == null) {
            return null;
        }
        TreeNode node = new TreeNode(integer);
        if (length == 1) {
            return node;
        }
        node.left = inorderTraversal(Arrays.copyOfRange(values, 0, root));
        node.right = inorderTraversal(Arrays.copyOfRange(values, root + 1, length));
        return node;
    }

    public static TreeNode createNodeBreadthFirst(Integer[] values) {
        checkTreeValues(0, 0, values.length);
        return breadthFirst(0, values);
    }

    public static TreeNode createNodeInorderTraversal(Integer[] values) {
        checkTreeValues(0, 0, values.length);
        return inorderTraversal(values);
    }

}
