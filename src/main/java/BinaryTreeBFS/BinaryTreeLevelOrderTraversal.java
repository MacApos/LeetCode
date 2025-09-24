package BinaryTreeBFS;

import BinaryTreeGeneral.general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{3, 9, 20, null, null, 15, 7});
        levelOrder(node);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(root, 0, result);
        return result;
    }

    public static void recursion(TreeNode root, int level,List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }

        recursion(root.left, level+1, result);
        recursion(root.right, level+1, result);
        result.get(level).add(root.val);
    }

}
