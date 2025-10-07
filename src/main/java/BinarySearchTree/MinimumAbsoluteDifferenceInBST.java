package BinarySearchTree;

import BinaryTreeGeneral.general.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{5, 2, 48, 1, 3, 12, 49});
        int minimumDifference = getMinimumDifference(node);
        System.out.println(minimumDifference);
    }

    public static int diff = Integer.MAX_VALUE;
    public static Integer prev = null;

    public static int getMinimumDifference(TreeNode root) {
        recursion(root);
        return diff;
    }

    public static void recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        recursion(root.left);

        if (prev != null) {
            diff = Math.min(diff, Math.abs(prev - root.val));
        }
        prev = root.val;

        recursion(root.right);
    }
}
