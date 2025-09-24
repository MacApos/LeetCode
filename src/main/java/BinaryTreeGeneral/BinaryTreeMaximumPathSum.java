package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createNodeBreadthFirst(new Integer[]{0, 9, 20, null, null, 15, 7});
        TreeNode root2 = TreeNode.createNodeBreadthFirst(new Integer[]{1,-2,3});
        maxPathSum(root2);
    }

    public static int maxPathSum(TreeNode root) {
        int[] max = {root.val};
        recursion(root, max);
        return max[0];
    }

    public static int recursion(TreeNode root, int[] max) {
        if (root==null){
            return 0;
        }

//        Math.max(0, ...) - because adding negative numbers to root won't increase its value, so it can't be max, hence
//        it is better to make them 0 so root value won't be changed
        int left = Math.max(0, recursion(root.left, max));
        int right = Math.max(0, recursion(root.right, max));

        max[0] = Math.max(max[0], left + right + root.val);

        return root.val + Math.max(left, right);

    }

}
