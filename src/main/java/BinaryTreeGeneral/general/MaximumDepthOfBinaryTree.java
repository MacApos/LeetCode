package BinaryTreeGeneral.general;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.createNodeBreadthFirst(values);
        int depth = maxDepth(root);
        System.out.println(depth);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}

