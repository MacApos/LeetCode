package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 3, 4, 5, 6, null});
        int i = countNodes(node);
    }

    public static int count = 0;

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return count;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
