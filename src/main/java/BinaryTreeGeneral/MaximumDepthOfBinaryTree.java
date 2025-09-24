package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;
import com.sun.source.tree.BinaryTree;

import javax.swing.text.View;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{3,9,20,null,null,15,7});
        int i = maxDepth2(node);
    }


    public static int depth = 0;
    public static int currDepth = 0;

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return currDepth;
        }
        currDepth++;
        maxDepth(root.left);
        maxDepth(root.right);
        depth = Math.max(depth, currDepth);
        return depth;
    }

    public static int maxDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return 1 + Math.max(left, right);
    }
}
