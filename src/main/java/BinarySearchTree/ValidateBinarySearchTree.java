package BinarySearchTree;

import BinaryTreeGeneral.general.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{5, 1, 4, null, null, 3, 6});
        TreeNode node2 = TreeNode.createNodeBreadthFirst(new Integer[]{5, 3, 6, 2, 4, null, null, 1, null, null, null,
                null, null, null, null});
        TreeNode node3 = TreeNode.createNodeBreadthFirst(new Integer[]{
                8,
                4, 12,
                2, 6, 10, 14,
                1, 3, 5, 7, 9, 11, 13, 16
        });
        TreeNode node4 = TreeNode.createNodeBreadthFirst(new Integer[]{
                2, 2, 2
        });
        boolean validBST = isValidBST(node4);

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        recursion2(root);
        return isValid;
    }

    public static Long previous = Long.MIN_VALUE;
    public static Integer prev = null;
    public static boolean isValid = true;


    public static boolean recursion(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = recursion(root.left);

        if (previous >= root.val) {
            return false;
        } else {
            previous = (long) root.val;
        }
        boolean right;

        if(left){
            right = recursion(root.right);
        } else {
            return false;
        }

        return right;
    }

    public static void recursion2(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion2(root.left);

        if (!isValid) {
            return;
        }

        if (prev == null) {
            prev = root.val;
        } else if (prev >= root.val) {
            isValid = false;
        } else {
            prev = root.val;
        }

        if (isValid) {
            recursion2(root.right);
        }
    }


}
