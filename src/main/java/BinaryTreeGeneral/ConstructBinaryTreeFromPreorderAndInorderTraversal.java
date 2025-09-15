package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3, 1, 2, 4};
        int[] inorder = {1, 2, 3, 4};
        TreeNode treeNode = buildTree(preorder, inorder);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = IntStream.range(0, inorder.length).boxed().collect(Collectors.toMap(i -> inorder[i], i -> i));
        return build(preorder, inorderMap, 0, inorder.length - 1);
    }

    public static int idx = 0;

    public static TreeNode build(int[] preorder, Map<Integer, Integer> inorderMap, int start, int end) {
        if (start > end) {
            return null;
        }

        int root = preorder[idx++];
        TreeNode node = new TreeNode(root);
        int inorderElement = inorderMap.get(root);

        node.left = build(preorder, inorderMap, start, inorderElement - 1);
        node.right = build(preorder, inorderMap, inorderElement + 1, end);

        return node;

    }
}
