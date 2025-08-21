package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 3, 2, 4, 2, 3});
        TreeNode q = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 3});
        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean pNull = p == null;
        boolean qNull = q == null;
        if (pNull && qNull) {
            return true;
        } else if (pNull || qNull) {
            return false;
        }

        if (p.val == q.val) {
            boolean isLeftSame = isSameTree(p.left, q.left);
            if (!isLeftSame) {
                return false;
            }
            return isSameTree(p.right, q.right);
        }
        return false;
    }
}
