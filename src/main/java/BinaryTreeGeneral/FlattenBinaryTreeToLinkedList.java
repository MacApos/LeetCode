package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.Stack;

/*
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solutions/6102240/0-ms-runtime-beats-100-user-code-idea-algorithm-solving-step/?envType=study-plan-v2&envId=top-interview-150
*/

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Integer[] node1Values = {1, 2, 5, 3, 4, null, 6};
        Integer[] node2Values = {1, null, null};
        Integer[] node3Values = {1, null, 2, null, 2, 3, null};
        TreeNode node1 = (TreeNode) TreeNode.createNodeBreadthFirst(node1Values);
        TreeNode node1ForStackFlatten = (TreeNode) TreeNode.createNodeBreadthFirst(node1Values);
        TreeNode node2 = (TreeNode) TreeNode.createNodeBreadthFirst(node2Values);
        TreeNode node3 = (TreeNode) TreeNode.createNodeBreadthFirst(node3Values);
        TreeNode node3ForSlowFlatten = (TreeNode) TreeNode.createNodeBreadthFirst(node3Values);

        flatten(node1);
        flattenStack(node3);
        slowFlatten(node3ForSlowFlatten);
    }

    public static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flattenStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        new Stack<>().push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (stack.isEmpty()) {
                break;
            }
            pop.right = stack.peek();
            pop.left = null;
        }
    }

    public static void slowFlatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        leftToRight(root, stack);
    }

    public static void leftToRight(TreeNode root, Stack<TreeNode> stack) {
        TreeNode right = root.right;
        TreeNode left = root.left;
        if (right != null) {
            stack.push(right);
        }
        if (left != null) {
            leftToRight(left, stack);
            root.right = left;
        } else {
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                leftToRight(pop, stack);
                root.right = pop;
            }
        }
        root.left = null;
    }
}
