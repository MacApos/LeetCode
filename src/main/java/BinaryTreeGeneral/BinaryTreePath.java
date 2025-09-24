package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;
import com.sun.source.tree.BinaryTree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 3, null, 5, null, null});
        List<String> strings = binaryTreePaths(root);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        return recursion(root, new ArrayList<>(), "");
    }

    public static List<String> recursion(TreeNode root, List<String> results, String path) {
        if (root == null) {
            return new ArrayList<>();
        }
        path += (path.isEmpty() ? path : "->") + root.val;
        if (root.left == null && root.right == null) {
            results.add(path);
        } else {
            recursion(root.left, results, path);
            recursion(root.right, results, path);
        }
        return results;
    }

    public static void recursion(TreeNode root, List<String> results, List<String> path) {
        if (root == null) {
            return;
        }
        path.add(root.val + "");
        if (root.left == null && root.right == null) {
            results.add(String.join("->", path));
        } else {
            recursion(root.left, results, path);
            recursion(root.right, results, path);
        }
        path.remove(path.size() - 1);
    }
}
