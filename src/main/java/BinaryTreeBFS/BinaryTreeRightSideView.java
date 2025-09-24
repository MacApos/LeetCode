package BinaryTreeBFS;

import BinaryTreeGeneral.general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 3, null, 5, null, 4});
        List<Integer> integers = rightSideView(node);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> view = new ArrayList<>();
        recursion(root, 0, view);
        return view;
    }

    public static void recursion(TreeNode root, int level, List<Integer> view) {
        if (root == null) {
            return;
        }
        if (view.size() == level) {
            view.add(root.val);
        }

//        Right nodes have priority,
//        level + 1 means this variable will be increased in inner function and won't be changed in outer function
//        alternatively:
//        level ++;
//        recursion(root.right, level , view);
//        recursion(root.left, level, view);
//        level--;


        level ++;
        recursion(root.right, level , view);
        recursion(root.left, level, view);
        level--;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            result.add(nodes.get(nodes.size() - 1).val);
            ArrayList<TreeNode> children = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    children.add(node.left);
                }
                if (node.right != null) {
                    children.add(node.right);
                }
            }
            nodes = children;
        }
        return result;
    }

    public static List<Integer> rightSideView3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        recursion3(new ArrayList<>(List.of(root)), result);
        return result;
    }

    public static void recursion3(List<TreeNode> nodes, ArrayList<Integer> result) {
        ArrayList<TreeNode> children = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                if (node.left != null) {
                    children.add(node.left);
                }
                if (node.right != null) {
                    children.add(node.right);
                }
            }
        }
        if (children.isEmpty()) {
            return;
        }

        result.add(children.get(children.size() - 1).val);
        recursion3(children, result);
    }
}
