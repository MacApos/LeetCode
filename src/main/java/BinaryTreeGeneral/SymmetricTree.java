package BinaryTreeGeneral;

import BinaryTreeGeneral.general.ConstructBinaryTreeFromPreorderAndInorderTraversal;
import BinaryTreeGeneral.general.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public static void main(String[] args) {
        Integer[] nodes1 = new Integer[]{1, 2, 2, 4, 3, 3, 4};
        Integer[] nodes2 = new Integer[]{1, 2, 2, null, 3, null, 3};
        TreeNode treeNodes = TreeNode.createNodeBreadthFirst(nodes1);
        boolean symmetric = isSymmetric(treeNodes);
        System.out.println(symmetric);
    }
    

    public static boolean isSymmetric(TreeNode root) {
        List<Integer> left = helper(root.left,true, new ArrayList<>());
        List<Integer> right = helper(root.right, false, new ArrayList<>());
        return left.equals(right);
    }

    public static List<Integer> helper(TreeNode node, boolean isPreorder, List<Integer> nodes) {
        if (node != null) {
            nodes.add(node.val);
            TreeNode left = node.left;
            TreeNode right = node.right;
            helper(isPreorder ? left : right, isPreorder, nodes);
            helper(isPreorder ? right : left, isPreorder, nodes);
        } else {
            nodes.add(null);
        }
        return nodes;
    }
}
