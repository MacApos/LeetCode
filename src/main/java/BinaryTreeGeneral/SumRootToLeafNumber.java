package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.List;

/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
https://leetcode.com/problems/sum-root-to-leaf-numbers/solutions/1556417/c-python-recursive-iterative-dfs-bfs-morris-traversal-o-1-beats-100/?envType=study-plan-v2&envId=top-interview-150
 */

public class SumRootToLeafNumber {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{4, 9, 0, 5, 1, null, null});
        TreeNode node2 = TreeNode.createNodeBreadthFirst(new Integer[]{9});

        int sumNumbers = sumNumbers(node);
        System.out.println(sumNumbers);

    }

    public static int sumNumbers(TreeNode root) {
        return recursion(root, 0);
    }

    public static int recursion(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }

        int val = prev * 10 + root.val;
        int leftVal = recursion(root.left, val);
        int rightVal = recursion(root.right, val);

        if ((root.left == null && root.right == null)) {
            return val;
        }
        return leftVal + rightVal;
    }

    public static List<Integer> recursion2(TreeNode root, List<Integer> result, int prev) {
        if (root == null) {
            return null;
        }
        int val = Integer.parseInt((prev > -1 ? prev : "") + String.valueOf(root.val));

        List<Integer> recursion1 = recursion2(root.left, result, val);
        List<Integer> recursion2 = recursion2(root.right, result, val);
        if ((root.left == null && root.right == null)) {
            System.out.println(val);
            result.add(val);
        }
        return result;
    }
}
