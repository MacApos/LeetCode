package BinaryTreeBFS;

import BinaryTreeGeneral.general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{3, 9, 20, null, null, 15, 7});
        zigzagLevelOrder(node);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(root, 0, false, result);
        return result;
    }

    public static void recursion(TreeNode root, int level, boolean zigZag, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }


        recursion(root.left, level + 1, !zigZag, result);
        recursion(root.right, level + 1, !zigZag, result);
        if(zigZag){
            result.get(level).add(0, root.val);
        } else {
            result.get(level).add( root.val);
        }
    }

}
