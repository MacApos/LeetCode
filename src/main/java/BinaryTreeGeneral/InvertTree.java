package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.List;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode node1 = TreeNode.createNodeBreadthFirst(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode node2 = new TreeNode();
        TreeNode invertedTree = invertTree(null);


    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        if(left != null){
            invertTree(left);
        }

        TreeNode temp = root.right;
        root.right = left;
        root.left = temp;

        if(temp != null){
            invertTree(temp);
        }
        return root;
    }
}
