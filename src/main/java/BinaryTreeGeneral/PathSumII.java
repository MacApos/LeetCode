package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        List<List<Integer>> lists = pathSum(node, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        return recursion(root, 0, sum, new ArrayList<>(), new ArrayList<>());
    }

    public static List<List<Integer>> recursion(TreeNode root, int currSum, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return new ArrayList<>();
        }

        currSum += root.val;
        list.add(root.val);

//        Node is a leaf - have no children
        if (root.left == null && root.right == null && currSum == sum) {
            result.add(new ArrayList<>(list));
        } else {
            recursion(root.left, currSum, sum, result, list);
            recursion(root.right, currSum, sum, result, list);
        }

        list.remove(list.size() - 1);
        return result;
    }
}
