package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        reversedIdx = postorder.length - 1;
        return build(inorderMap, postorder, 0, postorder.length - 1);
    }

    public static int reversedIdx;

    public static TreeNode build(Map<Integer, Integer> inorderMap, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int root = postorder[reversedIdx--];
        TreeNode treeNode = new TreeNode(root);
        Integer inorderElement = inorderMap.get(root);

        treeNode.right = build(inorderMap, postorder, inorderElement + 1, end);
        treeNode.left = build(inorderMap, postorder, start, inorderElement - 1);

        return treeNode;
    }

    public static Map<Integer, Integer> buildMap(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], i);
        }
        return hashMap;
    }

    private static TreeNode buildV2(Map<Integer, Integer> inorderMap, int[] inorder, int[] postorder) {
        if (inorder.length < 1) {
            return null;
        }

        int root = postorder[reversedIdx--];
        TreeNode treeNode = new TreeNode(root);
        Integer inorderElement = inorderMap.get(root);

        int[] left = Arrays.copyOfRange(inorder, 0, inorderElement);
        int[] right = Arrays.copyOfRange(inorder, inorderElement + 1, inorder.length);

        treeNode.right = buildV2(buildMap(right), right, postorder);
        treeNode.left = buildV2(buildMap(left), left, postorder);

        return treeNode;
    }
}
