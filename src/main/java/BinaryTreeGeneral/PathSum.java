package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;
import com.sun.source.tree.Tree;

public class PathSum {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1, null, null});
        boolean b = hasPathSum(node, 22);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }

        if (hasPathSum(root.left, targetSum)) return true;
        if (hasPathSum(root.right, targetSum)) return true;

        targetSum += root.val;

        return false;
    }
}
